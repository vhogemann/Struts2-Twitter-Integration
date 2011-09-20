package com.hogemann.stamp.persistence.xml;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import com.hogemann.stamp.persistence.ObjectRepository;

public abstract class AbstractMarshallingRepository<E> implements ObjectRepository<E> {

	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	private StreamFactory<E> streamFactory;
	
	public E get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public long save(E entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void update(E entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(E entity) {
		// TODO Auto-generated method stub
	}

}
