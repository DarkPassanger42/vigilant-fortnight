package jhu.edu.WebStore.Helpers;

/**
 * Base class for immutable domain objects that are loaded from a database and
 * never change after that.
 * 
 * @author Petter Holmstrom (IT Mill)
 */
public abstract class ImmutableDomainObject {

    private final long id;

    /**
     * Creates a new <code>ImmutableDomainObject</code>.
     * 
     * @param id
     *            the primary key that identifies the domain object in the
     *            database.
     */
    public ImmutableDomainObject(long id) {
        this.id = id;
    }

    /**
     * Gets the primary key that identifies the domain object in the database.
     * 
     * @return the primary key.
     */
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final ImmutableDomainObject other = (ImmutableDomainObject) obj;
        return other.id == id;
    }

    @Override
    public int hashCode() {
        return (int) (getClass().hashCode() * 97 + id);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
