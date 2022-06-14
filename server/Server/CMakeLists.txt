cmake_minimum_required(VERSION 3.17)
project(server C)

set(CMAKE_C_STANDARD 99)


add_executable(server Server/Server.c Server/lista_enlazada.h Server/logica.h server/constantes.h)

if(MINGW)
    target_link_libraries(server ws2_32)
endif()

