package com.siskom.networkcall1.presentation

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.siskom.networkcall1.R
import com.siskom.networkcall1.databinding.RowItemTestBinding

class TestingAdapter: BaseQuickAdapter<String, BaseDataBindingHolder<RowItemTestBinding>>(
    R. layout. row_item_test
) {
    override fun convert(holder: BaseDataBindingHolder<RowItemTestBinding>, item: String) {
       holder.dataBinding?.testing = item
    }
}