package com.example.amazingapp.viewmodel

import com.example.amazingapp.ui.picture.PictureOfTheDayResponseData

sealed class PictureOfTheDayState {
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseData):PictureOfTheDayState()
    data class Loading(val progress: Int?):PictureOfTheDayState()
    data class Error(val error: Throwable):PictureOfTheDayState()
}