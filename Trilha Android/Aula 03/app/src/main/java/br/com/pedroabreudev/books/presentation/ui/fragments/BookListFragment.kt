package br.com.pedroabreudev.books.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.pedroabreudev.books.databinding.FragmentBookListBinding
import br.com.pedroabreudev.books.domain.exception.EmptyBookListException
import br.com.pedroabreudev.books.domain.model.Book
import br.com.pedroabreudev.books.presentation.adapter.BookClickListener
import br.com.pedroabreudev.books.presentation.adapter.BookListAdapter
import br.com.pedroabreudev.books.presentation.viewmodel.BookListViewModel
import br.com.pedroabreudev.books.util.ViewState

class BookListFragment : Fragment(), BookClickListener {


    private lateinit var bookListAdapter: BookListAdapter
    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!

    private val viewModel: BookListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBookListData()
        configureListeners()
        addObserver()
    }

    private fun configureListeners() {
        binding.edSearch.textChangedListener = { input ->
            viewModel.search(input)
        }
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter(this)
        binding.rvBooks.adapter = bookListAdapter
        viewModel.search()
    }

    private fun addObserver() {
        viewModel.bookListViewState.observe(viewLifecycleOwner) { state ->

            when (state) {
                is ViewState.Success -> {
                    showEmptyListError(false)
                    bookListAdapter.submitList(
                        state.data
                    )
                }
                is ViewState.Error -> {
                    when (state.throwable) {
                        is EmptyBookListException -> {
                            bookListAdapter.submitList(listOf())
                            showEmptyListError(true)
                        }
                        else -> Unit
                    }
                }
                else -> Unit
            }

        }
    }

    private fun showEmptyListError(hasError: Boolean) {
        binding.tvEmptyList.visibility = if (hasError) View.VISIBLE else View.GONE
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsBottomSheet.newInstance(book).show(childFragmentManager, "book")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}