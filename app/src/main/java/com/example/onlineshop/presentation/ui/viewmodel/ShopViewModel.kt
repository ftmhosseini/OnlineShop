package com.example.onlineshop.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.domain.model.Product
import com.example.onlineshop.domain.model.User
import com.example.onlineshop.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(private val repository: Repository): ViewModel(){
    private val _user = MutableStateFlow<User?>(null)
    val user:StateFlow<User?> = _user.asStateFlow()
    private val _product = MutableStateFlow<Product?>(null)
    val product:StateFlow<Product?> = _product.asStateFlow()
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products:StateFlow<List<Product>> = _products.asStateFlow()
    fun getUser(){
        viewModelScope.launch {
            _user.value = repository.getUser()
        }
    }
    fun getProducts(){
        viewModelScope.launch {
            repository.getProducts().collect{
                _products.value = it
            }
        }
    }
    fun getProduct(index:Int){
        viewModelScope.launch {
            _product.value = repository.getProduct(index)
        }
    }

}