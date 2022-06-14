//
// Created by Usuario on 6/6/2022.
//

#ifndef SERVER_LISTA_ENLAZADA_H
#define SERVER_LISTA_ENLAZADA_H

/**
 * Struct nodo, estructura que seguirán los nodos de la lista enlazada
 * valor: numero que almacenará el nodo
 * sig: puntero hacia el nodo siguiente para recorrer la lista
 */
typedef struct snodo{
    int valor;
    struct snodo *sig;
}tnodo;

/**
 * Puntero al tipo de dato tnodo para no utilizar punteros de punteros
 */
typedef tnodo *tpuntero;


void insertarEnLista (tpuntero *cabeza, int e);
void imprimirLista (tpuntero cabeza);
void borrarLista (tpuntero *cabeza);


/**
 * Metodo para incertar un nuevo nodo en la lista
 * @param cabeza puntero al inicio de la lista
 * @param e valor a almacenar en el nodo
 */
void insertarEnLista (tpuntero *cabeza, int e){
    tpuntero nuevo;
    nuevo = malloc(sizeof(tnodo));
    nuevo->valor = e;

    nuevo->sig = *cabeza;
    *cabeza = nuevo;
}

/**
 * Funcion para imprimir la lista
 * @param cabeza puntero al inicio de la lista
 */
void imprimirLista(tpuntero cabeza){
    char value[2];

    while(cabeza != NULL){

        sprintf(value, "%d", cabeza->valor);

        printf("%s ", value);
        cabeza = cabeza->sig;
    }
}

/**
 * Funcion para borrar la lista y liberar el los espacios asignados
 * @param cabeza puntero al iniico de la lista
 */
void borrarLista(tpuntero *cabeza){
    tpuntero actual;

    while(*cabeza != NULL){
        actual = *cabeza;
        *cabeza = (*cabeza)->sig;
        free(actual);
    }
}


#endif //SERVER_LISTA_ENLAZADA_H
