package com.example.android.pagerduty.dish

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DishListViewModel :ViewModel(){
     var index:Int
     val _dishlist= MutableLiveData<MutableList<Dish>>()
    private var dishList: MutableList<Dish> = ArrayList()


    init {
        _dishlist.value=dishList
        index=0;

    }

    fun addDish(name: String, description: String){
        var dish = Dish(name,description, index);
        dishList.add(index,dish)
        _dishlist.value=dishList
        index++
    }

    fun deleteDish(i:Int){
        dishList.removeAt(i)
        Log.i("remove", i.toString());
        _dishlist.value=dishList
        index--;
    }


}