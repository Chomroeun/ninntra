package com.ninntra.development.model

import java.io.Serializable

class AddressItem(var addressId:String,var addressName:String,var houseName:String,var locality:String,var landmark:String,
                  var latitude:String,var longitude:String) : Serializable {

    constructor():this("","","","","","0.0","0.0")


    fun getAddress():String{
        return "$houseName, $locality. Landmark: $landmark"
    }
}