package org.xudong.ddd;

public abstract class AggregateRoot<ID extends Identifier> implements Entity<ID> {
    private final ID id;
    protected AggregateRoot(ID id) {
        this.id = id;
    }
    public ID getId() {
        return id;
    }
}
