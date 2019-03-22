#include <iostream>
#include <stdio.h>  
#include <curses.h>
using namespace std;  

int main(){
	initscr();
	string n,proveedor;
	
	do{
		
	
		cin>>proveedor;
		
	cout<<"***********************************************"<<endl;
	cout<<"                 Recarga Celular (En linea)    "<<endl;
	cout<<"***********************************************"<<endl;
	cout<<"Proveedor telefonico ______________"<<endl;
	cout<<"      Monto Recarga: $_____________"<<endl;
	cout<<"        Telefono: (503)____________  Nombre:______________"<<endl;
	cout<<""<<endl;
	cout<<"Ultimos 4 digitos                    CCV"<<endl;
	cout<<"  Targeta debito: XXX-XXXXX ____     verificador: ___"<<endl;
	cout<<""<<endl;
	cout<<"Presione... (S)Completar transaccion (N)Descartar Transaccion"<<endl;
	cin>>n;
	if(n=="s"){
		
		cout<<"Proveedor"+proveedor<<endl;
		}
	
}while((n=="N") || (n=="n"));
clear();
	endwin();
	return 0;
	}
