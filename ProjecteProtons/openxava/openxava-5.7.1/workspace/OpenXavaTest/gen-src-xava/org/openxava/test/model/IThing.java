

// File generated by OpenXava: Mon Jun 12 13:13:09 CEST 2017
// Archivo generado por OpenXava: Mon Jun 12 13:13:09 CEST 2017

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: Thing		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IThing  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_name = "name"; 
	String getName() throws RemoteException;
	void setName(String name) throws RemoteException; 	
	public static final String PROPERTY_number = "number"; 	
	int getNumber() throws RemoteException;		

	// References/Referencias

	// Methods 


}