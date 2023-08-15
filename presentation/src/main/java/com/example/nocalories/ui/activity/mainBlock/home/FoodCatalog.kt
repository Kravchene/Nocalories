package com.example.nocalories.ui.activity.mainBlock.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.damain.interfaceListener.MealClickListener
import com.example.damain.models.Meal
import com.example.damain.models.UserActivity
import com.example.nocalories.R
import com.example.nocalories.databinding.FragmentFoodCatalogBinding
import com.example.nocalories.ui.activity.mainBlock.home.Adapter.MealAdapter
import com.example.nocalories.ui.viewModel.MealViewModel

class FoodCatalog : Fragment(), MealClickListener {

    lateinit var binding:FragmentFoodCatalogBinding
    private lateinit var viewModel: MealViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodCatalogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MealViewModel::class.java)
        val adapter = MealAdapter(this@FoodCatalog)
        val mealList:MutableList<Meal> =  mutableListOf()
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
            recyclerView.setItemViewCacheSize(3)
        }


        mealList.add(Meal("https://i.pinimg.com/236x/7c/b1/e1/7cb1e13b1ffdd6aa528c05701d706a48.jpg","Курица жареная",30.0,2.0,12.0,0.0,219))
        mealList.add(Meal("https://suomimagazin.ru/800/600/http/mtdata.ru/u25/photo1814/20924502940-0/original.jpg","Курица варёная или тушёная",27.0,0.0,7.0,0.0,177))
        mealList.add(Meal("https://edaprof.ru/image/catalog/aromatizatori/banan/aromatizator-banan-pishchevoy-zhidkiy-6-min.jpg","Бананы",1.0,23.0,1.0,3.0,219))
        mealList.add(Meal("https://rassadacvetov.com/wp-content/uploads/2020/04/Grusha-Osennyaya-YAkovleva.jpg","Груша",0.4,15.2,0.1,3.1,57))
        mealList.add(Meal("https://cs9.pikabu.ru/post_img/2019/01/28/7/1548673947167350407.jpg","Яблоки",0.3,13.8,0.2,2.4,52))
        mealList.add(Meal("https://edaprof.ru/image/catalog/suhie-soki/cuhoj-naturalnyj-sok-yabloka-4-min.jpg","Сок яблочный",0.1,11.3,0.1,0.2,46))
        mealList.add(Meal("https://byfood.s3-sa-east-1.amazonaws.com/files/empresas/14927/delivery/produtos/Abacaxi-102325232ec3c57bc2fd44dac1b88b61_n.jpg","Сок ананасовый",0.4,12.9,0.1,0.2,53))
        mealList.add(Meal("https://avatars.dzeninfra.ru/get-zen_doc/8098241/pub_640075b32870e15cf2470294_64024dc58d71710ef9210988/scale_1200","Картофель варёный",1.7,20.0,0.1,1.8,86))
        mealList.add(Meal("https://cdn.shopify.com/s/files/1/0503/0071/5187/articles/Rosemary_Roasted_Potatoes_shutterstock_766423915_700x700_crop_center.jpg?v=1605092474","Картофель жареный",3.0,35.1,12.5,3.2,265))
        mealList.add(Meal("https://www.kitchentreaty.com/wp-content/uploads/2015/02/sticky-coconut-rice-with-scallionssq.jpg","Рис варёный",2.4,28.6,0.2,0.0,130))
        mealList.add(Meal("https://yukber.uz/image/cache/catalog/product/YK5014/5014-700x700.jpg","Каша овсяная на воде",2.5,12.0,1.5,1.7,71))
        mealList.add(Meal("https://shop.r10s.jp/f434337-minamiaso/cabinet/06893703/06900231/700700.jpg","Лапша гречневая (соба) варёная",5.1,21.4,0.1,0.0,99))

        adapter.setData(mealList)

    }

    override fun onClick(meal: Meal) {
        viewModel.setMyData(meal)
        findNavController().navigate(R.id.action_foodCatalog_to_food2)
    }

}