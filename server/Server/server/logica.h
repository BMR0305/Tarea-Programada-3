//
// Created by Usuario on 6/6/2022.
//

#ifndef SERVER_LOGICA_H
#define SERVER_LOGICA_H
#include "lista_enlazada.h"
#include<stdio.h>
#include<stdlib.h>
#include <string.h>


struct snodo* crear_tablero(){
    tpuntero cabeza; //Indica la cabeza de la lista enlazada, si la perdemos no podremos acceder a la lista
    cabeza = NULL; //Se inicializa la cabeza como NULL ya que no hay ningun nodo cargado en la lista
    //char add = '%';
    //insertarEnLista (&cabeza, add);
    for (int i = 8; i > 0; --i) {
        for (int j = 0; j < 6; ++j) {
            insertarEnLista(&cabeza, i);
            int r = rand() % 7;
            insertarEnLista(&cabeza, r);
        }
    }
    printf("\n");
    //imprimirLista (cabeza);
    return cabeza;
}


int write(const char *str) {
    //const char *str = "Temporary string to be written to file!";

    const char* filename = "out.txt";

    FILE* output_file = fopen(filename, "w+");
    if (!output_file) {
        perror("fopen");
        //exit(EXIT_FAILURE);
    }

    fwrite(str, 1, strlen(str), output_file);

    fclose(output_file);
    //exit(EXIT_SUCCESS);

}

#endif //SERVER_LOGICA_H
