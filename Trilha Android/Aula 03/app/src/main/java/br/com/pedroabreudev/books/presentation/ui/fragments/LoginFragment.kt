package br.com.pedroabreudev.books.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.pedroabreudev.books.databinding.FragmentLoginBinding
import br.com.pedroabreudev.books.presentation.viewmodel.LoginViewModel
import br.com.pedroabreudev.books.util.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        addObserver()
    }

    private fun setListener() {
        binding.enterButton.setOnClickListener {
            binding.run {
                loginViewModel.login(
                    textFieldEditEmail.text.toString(),
                    textFieldEditPassword.text.toString()
                )
                textFieldEditEmail.addTextChangedListener {
                    textError.visibility = View.GONE
                }
                textFieldEditPassword.addTextChangedListener {
                    textError.visibility = View.GONE
                }
            }
        }
    }

    private fun addObserver() {
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToBookListFragment()
                    )
                }
                is ViewState.Error -> {
//                    binding.textError.text = state.throwable.message
                    binding.progressDialog.visibility = View.GONE
                    binding.textError.visibility = View.VISIBLE

                }

                is ViewState.Loading -> {
                    binding.progressDialog.visibility = View.VISIBLE
                }
                else -> Unit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }

}