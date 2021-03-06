#undef UNICODE

#define WIN32_LEAN_AND_MEAN

#include <windows.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "logica.h"
#include "constantes.h"

// Need to link with Ws2_32.lib
#pragma comment (lib, "Ws2_32.lib")
// #pragma comment (lib, "Mswsock.lib")

/**
 * Metodo para la creacion y apertura de los sockets del servidor
 * Se encarga de recibir los mensajes y al clasificarlo seleccionarÃ¡
 * el procedimiento a realizar.
 * @return
 */

int __cdecl main(void) {

    WSADATA wsaData;
    int iResult;

    SOCKET ListenSocket = INVALID_SOCKET;
    SOCKET ClientSocket = INVALID_SOCKET;

    struct addrinfo *result = NULL;
    struct addrinfo hints;

    int iSendResult;
    char recvbuf[DEFAULT_BUFLEN];
    int recvbuflen = DEFAULT_BUFLEN;



    // Initialize Winsock
    iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);
    if (iResult != 0) {
        printf("WSAStartup failed with error: %d\n", iResult);
        return 1;
    }

    ZeroMemory(&hints, sizeof(hints));
    hints.ai_family = AF_INET;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_protocol = IPPROTO_TCP;
    hints.ai_flags = AI_PASSIVE;

    // Resolve the server address and port
    iResult = getaddrinfo(NULL, DEFAULT_PORT, &hints, &result);
    if (iResult != 0) {
        printf("getaddrinfo failed with error: %d\n", iResult);
        WSACleanup();
        return 1;
    }

    // Create a SOCKET for connecting to server
    ListenSocket = socket(result->ai_family, result->ai_socktype, result->ai_protocol);
    if (ListenSocket == INVALID_SOCKET) {
        printf("socket failed with error: %ld\n", WSAGetLastError());
        freeaddrinfo(result);
        WSACleanup();
        return 1;
    }

    // Setup the TCP listening socket
    iResult = bind(ListenSocket, result->ai_addr, (int) result->ai_addrlen);
    if (iResult == SOCKET_ERROR) {
        printf("bind failed with error: %d\n", WSAGetLastError());
        freeaddrinfo(result);
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    freeaddrinfo(result);

    iResult = listen(ListenSocket, SOMAXCONN);
    if (iResult == SOCKET_ERROR) {
        printf("listen failed with error: %d\n", WSAGetLastError());
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    while (TRUE) {
        // Accept a client socket
        ClientSocket = accept(ListenSocket, NULL, NULL);
        if (ClientSocket == INVALID_SOCKET) {
            printf("accept failed with error: %d\n", WSAGetLastError());
            closesocket(ListenSocket);
            WSACleanup();
            return 1;
        }

        // No longer need server socket
        //closesocket(ListenSocket);


        // Receive until the peer shuts down the connection
        do {

            iResult = recv(ClientSocket, recvbuf, recvbuflen, 0);
            if (iResult > 0) {
                printf("Bytes received: %d %s\n", iResult, recvbuf);

                char *ptr;
                int level = strtol(recvbuf, &ptr, 10);
                char game[243];

                if (level == 1) {
                    struct snodo* cabeza;
                    cabeza = crear_tablero();

                    memset(game, 0, 243);
                    char value [2];
                    char add [1];
                    strcpy(add,"%");

                    /**
                     * Se extraerÃ¡ la infromacion de la lista para
                     * almacenara en un string para su envio por los sockets
                     */
                    while(cabeza != NULL){

                        sprintf(value, "%d", cabeza->valor);
                        strcat(game, value);
                        cabeza = cabeza->sig;

                        strcpy(add,"_");
                        strcat(game,add);

                        sprintf(value, "%d", cabeza->valor);
                        strcat(game, value);
                        strcpy(add,"0");
                        strcat(game,add);
                        cabeza = cabeza->sig;

                        strcpy(add,"%");
                        strcat(game,add);
                    }

                    printf("%s\n", game);
                    // Echo the buffer back to the sender
                    iSendResult = send(ClientSocket, game, 260, 0);
                }
                else{
                    write(recvbuf);
                }


                if (iSendResult == SOCKET_ERROR) {
                    printf("send failed with error: %d\n", WSAGetLastError());
                    closesocket(ClientSocket);
                    WSACleanup();
                    return 1;
                }
                printf("Bytes sent: %d\n", iSendResult);
            } else if (iResult == 0)
                printf("Connection closing...\n");
            else {
                iResult=0;
            }

        } while (iResult > 0);


        // shutdown the connection since we're done
        iResult = shutdown(ClientSocket, SD_SEND);
        if (iResult == SOCKET_ERROR) {
            printf("shutdown failed with error: %d\n", WSAGetLastError());
            closesocket(ClientSocket);
            WSACleanup();
            return 1;
        }

    }
        // cleanup
        closesocket(ClientSocket);
        WSACleanup();

        //return 0;

}