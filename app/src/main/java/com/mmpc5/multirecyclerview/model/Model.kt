package com.mmpc5.multirecyclerview.model

class Model(var type: Int, var text: String, var data: Int) {
    companion object {


        const val TEXT_TYPE = 0
        const val RECYCLER_RECLAME_TYPE = 1
        const val RECYCLER_CONTACT_TYPE = 2
    }
}
