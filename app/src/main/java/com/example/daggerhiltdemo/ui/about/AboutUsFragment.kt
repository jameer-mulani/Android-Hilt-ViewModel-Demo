package com.example.daggerhiltdemo.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.daggerhiltdemo.R
import com.example.daggerhiltdemo.databinding.FragmentAboutusBinding
import com.example.daggerhiltdemo.di.AboutUsFragmentName
import com.example.daggerhiltdemo.di.LibraryKey
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AboutUsFragment : Fragment() {

    private lateinit var binding: FragmentAboutusBinding
    private lateinit var aboutUsViewModel: AboutUsViewModel

    @Inject
    @LibraryKey
    lateinit var libKey : String

    @Inject
    @AboutUsFragmentName
    lateinit var fragmentName: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutUsViewModel = ViewModelProvider(this)[AboutUsViewModel::class.java]
        binding = FragmentAboutusBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCopyrightLbl.text = aboutUsViewModel.getCopyRightInfo()

        Toast.makeText(requireContext(), "name : $fragmentName", Toast.LENGTH_SHORT ).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AboutUsFragment()
    }
}