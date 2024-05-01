package com.example.newinfoapp

object DataManager {
    private val itemList: MutableList<ItemData> = mutableListOf()

    fun addItem(itemData: ItemData){
        itemList.add(itemData)
    }
    fun addList(itemListOfData: List<ItemData>): List<ItemData>{
       itemList.addAll(itemListOfData)
        return itemList
    }
    fun getItemListByType(type: String): List<ItemData> {
        return itemList.filter { it.type == type }
    }
    fun getItem(id : Int) : ItemData? {
        return itemList.find { it.id == id }
    }
}


