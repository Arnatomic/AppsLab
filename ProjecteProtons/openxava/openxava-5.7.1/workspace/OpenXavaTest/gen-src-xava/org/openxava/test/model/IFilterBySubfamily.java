

// File generated by OpenXava: Mon Jun 12 13:13:08 CEST 2017
// Archivo generado por OpenXava: Mon Jun 12 13:13:08 CEST 2017

// WARNING: NO EDIT
// OJO: NO EDITAR
// Component: FilterBySubfamily		Java interface for entity/Interfaz java para Entidad

package org.openxava.test.model;

import java.math.*;
import java.rmi.RemoteException;


public interface IFilterBySubfamily  extends org.openxava.model.IModel {	

	// Properties/Propiedades 	
	public static final String PROPERTY_rangeDescription = "rangeDescription"; 	
	String getRangeDescription() throws RemoteException;		

	// References/Referencias 

	// SubfamilyTo : Reference/Referencia
	
	org.openxava.test.model.ISubfamily2 getSubfamilyTo() throws RemoteException;
	void setSubfamilyTo(org.openxava.test.model.ISubfamily2 newSubfamilyTo) throws RemoteException; 

	// Subfamily : Reference/Referencia
	
	org.openxava.test.model.ISubfamily2 getSubfamily() throws RemoteException;
	void setSubfamily(org.openxava.test.model.ISubfamily2 newSubfamily) throws RemoteException;

	// Methods 


}