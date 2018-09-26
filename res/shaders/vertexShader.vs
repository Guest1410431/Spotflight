#version 150

in vec3 position;
in vec2 textCoords;

out vec2 passTextCoords;

uniform mat4 transformation;

void main(void) 
{
	gl_Position = transformation * vec4(position, 1.0);
	passTextCoords = textCoords;
}