package com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContentViewModel(private val contentRepository: ContentRepository, id: Int) :
    ViewModel() {

    private val _contentList = MutableLiveData<List<ContentModel>>()
    val contentList: LiveData<List<ContentModel>> = _contentList

    init {
        _contentList.value = contentRepository.getWithMenuId(id)
    }
}