package mate.academy.internetshop.dao.impl;

import java.util.NoSuchElementException;

import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.lib.IdGenerator;
import mate.academy.internetshop.model.Bucket;

@Dao
public class BucketDaoImpl implements BucketDao {
    @Override
    public Bucket create(Bucket bucket) {
        bucket.setId(IdGenerator.getBucketId());
        Storage.buckets.add(bucket);
        return bucket;
    }

    @Override
    public Bucket get(Long bucketId) {
        return Storage.buckets
                .stream().filter(b -> b.getId().equals(bucketId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Can't find bucket with id " + bucketId));
    }

    @Override
    public Bucket update(Bucket bucket) {
        Bucket old = Storage.buckets
                .stream()
                .filter(b -> b.getId().equals(bucket.getId()))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't update bucket with id "
                                + bucket.getId()));
        int index = Storage.buckets.indexOf(old);
        return Storage.buckets.set(index, bucket);
    }

    @Override
    public boolean deleteById(Long id) {
        Bucket old = Storage.buckets
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't delete bucket with id " + id));
        return delete(old);
    }

    @Override
    public boolean delete(Bucket bucket) {
        return Storage.buckets.remove(bucket);
    }
}
