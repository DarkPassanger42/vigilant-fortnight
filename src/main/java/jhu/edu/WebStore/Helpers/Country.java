package jhu.edu.WebStore.Helpers;

/**
 * This domain class represents a country. Instances of this class are
 * immutable, as they are expected to be initialized from a read-only data
 * source.
 * 
 * @author Petter Holmstrom (IT Mill)
 */
public final class Country extends ImmutableDomainObject {

    private static final long serialVersionUID = 221953316815554805L;

    private final String name;

    private volatile int cachedHashCode;

    /**
     * Creates a new <code>Country</code>.
     * 
     * @param id
     *            the primary key that identifies the country in the database.
     * @param name
     *            the name of the country (must not be <code>null</code>).
     */
    public Country(long id, String name) {
        super(id);
        assert name != null : "name must not be null";
        this.name = name;
    }

    /**
     * Gets the name of the country.
     * 
     * @return the name (never <code>null</code>).
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return name.equals(((Country) obj).name);
    }

    @Override
    public int hashCode() {
        int hash = cachedHashCode;
        if (hash == 0) {
            hash = super.hashCode();
            hash = 97 * hash + name.hashCode();
            cachedHashCode = hash;
        }
        return hash;
    }

    /**
     * Creates an instance of <code>Country</code> with dummy data, useful for
     * testing.
     * 
     * @return a new <code>Country</code> instance.
     */
    public static Country createDummy() {
        return new Country(1, "A Country");
    }
}