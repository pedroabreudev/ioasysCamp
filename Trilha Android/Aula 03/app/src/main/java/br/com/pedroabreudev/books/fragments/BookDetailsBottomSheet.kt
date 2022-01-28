package br.com.pedroabreudev.books.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.pedroabreudev.books.R
import br.com.pedroabreudev.books.databinding.BottomSheetBookDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookDetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetBookDetailsBinding? = null
    private val binding: BottomSheetBookDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = BottomSheetBookDetailsBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}