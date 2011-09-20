package com.hogemann.stamp.persistence.xml;

import java.io.InputStream;
import java.io.OutputStream;


/**
 * Utilizada pelo {@link AbstractMarshallingRepository} para saber de onde ler
 * e onde salvar os arquivos serializados.
 * 
 * @author victor
 *
 * @param <E>
 */
public interface StreamFactory<E> {
	
	public InputStream getInputStream(E entity);
	
	public OutputStream getOutputStream(E entity);
}
