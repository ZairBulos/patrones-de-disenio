package refactoring.guru.iterators;

import refactoring.guru.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
