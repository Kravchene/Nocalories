package com.example.nocalories.ui.activity.mainBlock.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.damain.logic.ActivityLogic
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentGalleryBinding
import com.example.nocalories.ui.viewModel.UserMetricsViewModel
import com.example.nocalories.ui.viewModel.UserViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment : Fragment() {

    lateinit var binding: FragmentGalleryBinding
    private val user: UserViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            user.user.collectLatest { user ->
                if (user.isNotEmpty()) {
                    with(binding) {
                        UserName.text=user.last().name
                        gender.text=when (user.last().gender){
                            0->"Мужчина"
                            1->"Женщина"
                            else -> {"Женщина"}
                        }
                        goal.text= when(user.last().goal){
                            0->"Быть в форме"
                            1->"Похудеть"
                            else -> {"Набрать мышечную массу"}
                        }
                        year.text=user.last().age.toString()
                        height.text=user.last().height.toString()
                        weight.text=user.last().weight.toString()
                    }
                }
            }
        }
        with (binding){
            update1.setOnClickListener {
                findNavController().navigate(R.id.action_nav_pofel_to_changeGender)
            }
            update2.setOnClickListener {
                findNavController().navigate(R.id.action_nav_pofel_to_changeGoal)
            }
            update3.setOnClickListener {
                findNavController().navigate(R.id.action_nav_pofel_to_changeAge)
            }
            update4.setOnClickListener {
                findNavController().navigate(R.id.action_nav_pofel_to_changeHeight2)
            }

        }
    }


}