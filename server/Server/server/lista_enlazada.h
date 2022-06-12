//
// Created by Usuario on 6/6/2022.
//

#ifndef SERVER_LISTA_ENLAZADA_H
#define SERVER_LISTA_ENLAZADA_H

typedef struct snodo{ //snodo es el nombre de la estructura
    int valor;
    struct snodo *sig; //El puntero siguiente para recorrer la lista enlazada
}tnodo; //tnodo es el tipo de dato para declarar la estructura

typedef tnodo *tpuntero; //Puntero al tipo de dato tnodo para no utilizar punteros de punteros


void insertarEnLista (tpuntero *cabeza, int e);
void imprimirLista (tpuntero cabeza);
void borrarLista (tpuntero *cabeza);


void insertarEnLista (tpuntero *cabeza, int e){
    tpuntero nuevo; //Creamos un nuevo nodo
    nuevo = malloc(sizeof(tnodo)); //Utilizamos malloc para reservar memoria para ese nodo
    nuevo->valor = e; //Le asignamos el valor ingresado por pantalla a ese nodo
    tpuntero actual; //Puntero auxiliar para eliminar correctamente la lista

    nuevo->sig = *cabeza; //Le asignamos al siguiente el valor de cabeza
    *cabeza = nuevo; //Cabeza pasa a ser el ultimo nodo agregado
}

void imprimirLista(tpuntero cabeza){
    char value[2];

    while(cabeza != NULL){ //Mientras cabeza no sea NULL

        sprintf(value, "%d", cabeza->valor);

        printf("%s ", value); //Imprimimos el valor del nodo
        cabeza = cabeza->sig; //Pasamos al siguiente nodo
    }
}

void borrarLista(tpuntero *cabeza){
    tpuntero actual; //Puntero auxiliar para eliminar correctamente la lista

    while(*cabeza != NULL){ //Mientras cabeza no sea NULL
        actual = *cabeza; //Actual toma el valor de cabeza
        *cabeza = (*cabeza)->sig; //Cabeza avanza 1 posicion en la lista
        free(actual); //Se libera la memoria de la posicion de Actual (el primer nodo), y cabeza queda apuntando al que ahora es el primero
    }
}



#endif //SERVER_LISTA_ENLAZADA_H
