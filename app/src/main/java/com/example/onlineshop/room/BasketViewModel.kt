package com.example.onlineshop.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BasketViewModel(private val dao: BasketDao) : ViewModel() {
    val items = dao.getAllItems().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun increase(item: BasketItem) = viewModelScope.launch {
        dao.update(item.copy(quantity = item.quantity + 1))
    }

    fun decrease(item: BasketItem) = viewModelScope.launch {
        if (item.quantity > 1) {
            dao.update(item.copy(quantity = item.quantity - 1))
        } else {
            dao.delete(item)
        }
    }

    fun addItem(item: BasketItem) {
        viewModelScope.launch {
            dao.insert(item)
        }
    }

    fun getTotalPrice(): Long = items.value.sumOf { it.price * it.quantity }

    fun getTotalDiscount(): Long =
        kotlin.math.round(items.value.sumOf { (it.discount / 100.0) * it.quantity * it.price })
            .toLong()

    fun getFinalAmount(): Long = getTotalPrice() - getTotalDiscount()
}
