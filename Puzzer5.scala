def sumSizes(collections: Iterable[Iterable[_]]): Int =
  collections.toSeq.map(_.size).sum;


def sumSizes2(collections: Iterable[Iterable[_]]): Int =
  collections.foldLeft(0){(sumOfSizes, collection) => sumOfSizes + collection.size};

sumSizes2(List(Set(1, 2), Set(3, 4)))
sumSizes2(Set(List(1, 2), Set(3, 4)))
