package pl.spring.demo.aop;

import org.springframework.aop.MethodBeforeAdvice;
import pl.spring.demo.dao.impl.BookDaoImpl;
import pl.spring.demo.to.BookTo;

import java.lang.reflect.Method;

/**
 * An advice to set book id before save.
 */
public class SetBookIdAdvice implements MethodBeforeAdvice {

	/**
	 * Function that sets book id before save.
	 */
	@Override
	public final void before(final Method method, final Object[] objects, final Object o) throws Throwable {
		if (objects[0] != null && ((BookTo) objects[0]).getId() == null) {
			((BookTo) objects[0]).setId(((BookDaoImpl) o).generateId());
		}
	}
}
