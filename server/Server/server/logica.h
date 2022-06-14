//
// Created by Usuario on 6/6/2022.
//

#ifndef SERVER_LOGICA_H
#define SERVER_LOGICA_H
#include "lista_enlazada.h"
#include<stdio.h>
#include<stdlib.h>
#include <string.h>

/**
 * Funcion para crear el tablero de cada nivel, asiganrá el puntaje dependiendo de
 * la fila donde se encuentre el ladrillo y se asignará un poder aleatorio.
 * @return puntero al inicio de la lista
 */
struct snodo* crear_tablero(){
    tpuntero cabeza;
    cabeza = NULL;

    for (int i = 1; i < 9; ++i) {
        for (int j = 0; j < 6; ++j) {
            insertarEnLista(&cabeza, i);
            int r = rand() % 7;
            insertarEnLista(&cabeza, r);
        }
    }
    printf("\n");
    return cabeza;
}


/**
 * Funcion para almacenar la infromacion del juego para luego
 * pasarla a el espectador
 * @param str informacion del juego
 * @return si existe algun error
 */
int write(const char *str) {

    const char* filename = "gameInfo.txt";

    FILE* output_file = fopen(filename, "w+");
    if (!output_file) {
        perror("fopen");

    }
    fwrite(str, 1, strlen(str), output_file);

    fclose(output_file);

}

#endif //SERVER_LOGICA_H
