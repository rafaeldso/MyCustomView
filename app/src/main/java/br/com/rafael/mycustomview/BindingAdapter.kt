package br.com.rafael.mycustomview

import androidx.databinding.BindingAdapter

@BindingAdapter("onClearCallback")
fun EDTComponent.onClearCallback(callback: () -> Unit) {
    this.setOnClearCallback(callback)
}