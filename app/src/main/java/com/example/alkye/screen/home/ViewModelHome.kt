package com.example.alkye.screen.home

import androidx.lifecycle.ViewModel

class ViewModelHome : ViewModel() {

    val horizontalList = ArrayList<String>()
    val verticalList = ArrayList<String>()
    val footerList = ArrayList<String>()

    init {
        horizontalList.addAll(getDummyData())
        footerList.addAll(getDummyData())
        verticalList.addAll(getRecentData())
    }


    fun showAllVerticalList(){
        for(i in 6..20){
            verticalList.add("item $i")
        }
    }

    private fun getDummyData(): List<String> {
        val items: MutableList<String> = ArrayList()
        for (i in 1..20) {
            items.add("Item $i")
        }
        return items
    }

    private fun getRecentData() : List<String> {
        val items: MutableList<String> = ArrayList()
        for (i in 1..5) {
            items.add("Item $i")
        }
        return items
    }
}