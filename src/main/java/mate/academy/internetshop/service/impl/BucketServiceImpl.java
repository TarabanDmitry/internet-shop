package mate.academy.internetshop.service.impl;

import java.util.List;

import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.service.BucketService;

@Service
public class BucketServiceImpl implements BucketService {

    private BucketDao bucketDao;

    @Override
    public Bucket create(Bucket bucket) {
        return bucketDao.create(bucket);
    }

    @Override
    public Bucket get(Long bucketId) {
        return bucketDao.get(bucketId);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketDao.update(bucket);
    }

    @Override
    public boolean deleteById(Long bucketId) {
        return bucketDao.deleteById(bucketId);
    }

    @Override
    public boolean delete(Bucket bucket) {
        return bucketDao.delete(bucket);
    }

    @Override
    public void delete(Bucket bucket, Item item) {
        bucket.getItems().remove(item);
        update(bucket);
    }

    @Override
    public void addItem(Bucket bucket, Item item) {
        bucket.getItems().add(item);
        update(bucket);
    }

    @Override
    public void clear(Bucket bucket) {
        bucket.getItems().clear();
        update(bucket);
    }

    @Override
    public List<Item> getAllItems(Bucket bucket) {
        return bucket.getItems();
    }
}
