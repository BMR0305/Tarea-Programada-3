# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/server.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/server.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/server.dir/flags.make

CMakeFiles/server.dir/server/Server.c.obj: CMakeFiles/server.dir/flags.make
CMakeFiles/server.dir/server/Server.c.obj: ../server/Server.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/server.dir/server/Server.c.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\server.dir\server\Server.c.obj   -c C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\server\Server.c

CMakeFiles/server.dir/server/Server.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/server.dir/server/Server.c.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\server\Server.c > CMakeFiles\server.dir\server\Server.c.i

CMakeFiles/server.dir/server/Server.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/server.dir/server/Server.c.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\server\Server.c -o CMakeFiles\server.dir\server\Server.c.s

# Object files for target server
server_OBJECTS = \
"CMakeFiles/server.dir/server/Server.c.obj"

# External object files for target server
server_EXTERNAL_OBJECTS =

server.exe: CMakeFiles/server.dir/server/Server.c.obj
server.exe: CMakeFiles/server.dir/build.make
server.exe: CMakeFiles/server.dir/linklibs.rsp
server.exe: CMakeFiles/server.dir/objects1.rsp
server.exe: CMakeFiles/server.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable server.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\server.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/server.dir/build: server.exe

.PHONY : CMakeFiles/server.dir/build

CMakeFiles/server.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\server.dir\cmake_clean.cmake
.PHONY : CMakeFiles/server.dir/clean

CMakeFiles/server.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\cmake-build-debug C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\cmake-build-debug C:\Users\Usuario\Documents\GitHub\Tarea-Programada-3\server\Server\cmake-build-debug\CMakeFiles\server.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/server.dir/depend
