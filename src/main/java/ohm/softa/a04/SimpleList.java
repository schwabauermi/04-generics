package ohm.softa.a04;

public interface SimpleList <T> extends Iterable<T> {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T o);

	/**
	 * @return current size of the list
	 */
	int size();


	default void addDefault(Class<T> clazz) {
		try {
			this.add(clazz.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get a new SimpleList instance with all items of this list which match the given filter
	 * @param filter SimpleFilter instance
	 * @return new SimpleList instance
	 */
	default SimpleList<T> filter(SimpleFilter<T> filter){
		SimpleList<T> result = new SimpleListImpl<>();
		for(T o : this){
			if(filter.include(o)){
				result.add(o);
			}
		}
		return result;
	}

}
