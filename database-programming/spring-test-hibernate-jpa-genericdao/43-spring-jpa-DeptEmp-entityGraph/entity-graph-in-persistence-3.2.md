

# https://in.relation.to/2024/04/01/jakarta-persistence-3/

EntityGraph

  The `EntityGraph` facility, first introduced in JPA 2.1 used to be, well, a bit of a mess. (You can’t blame me this time, I didn’t contribute to 2.1.) In `Persistence 3.2`, we’ve cleaned up this whole API, and made it much more usable. We even had to deprecate certain incorrectly-typed methods, which we’ve scheduled for removal in 4.0. We’ve also moved away from the whole confusing “fetch graph” vs “load graph” distinction.

  Of course, EntityGraphs didn’t get left behind by the type safety bus.

    var bookWithAuthors = em.createEntityGraph(Book.class);
    bookWithAuthors.removeAttributeNode(Book_.publisher);
    bookWithAuthors.addAttributeNode(Book_.authors);

    var book = em.find(bookWithAuthors, isbn);

  Graphs declared using `@NamedEntityGraph` are available via the static metamodel.

    var book = em.find(Book_.withAuthors, isbn);

  Don’t get too excited by this feature; the @NamedEntityGraph annotation itself is still pretty awful to work with, and so it’s still better to specify entity graphs in code.
