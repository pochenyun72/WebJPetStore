package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.persistence.ItemManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemManageService {

    @Autowired
    ItemManageMapper itemManageMapper;

    public void insertItem(Item item){
        itemManageMapper.insertQuantity(item);
        itemManageMapper.insertItem(item);
    }

    public void updateItem(Item item){
        itemManageMapper.updateItem(item);
        itemManageMapper.updateInventoryQuantity(item);
    }

    public List<Item> getItemList(){
        return itemManageMapper.getItemList();
    }

    public Item getItem(String itemId){
        return itemManageMapper.getItem(itemId);
    }

    public void removeItemById(String itemId){
        itemManageMapper.removeItemById(itemId);
        itemManageMapper.removeInventoryById(itemId);
    }

    public List<Item> searchItemList(String keyValue){
        return itemManageMapper.searchItemList("%" + keyValue.toLowerCase() + "%");
    }
}
