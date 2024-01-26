package com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel

import com.mustafa.mvvmandnavigationincompose.R
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderModel

class ContentRepository() {

    private val contentList = mutableListOf<ContentModel>()


    init {

        contentList.add(ContentModel(101, R.drawable.mercimek_corba, "Mercimek Çorbası", 50))
        contentList.add(ContentModel(102, R.drawable.tavuk_corba, "Tavuk Çorbası", 70))
        contentList.add(ContentModel(103, R.drawable.domates_corba, "Domates Çorbası", 45))
        contentList.add(ContentModel(104, R.drawable.yogurtlu_corba, "Yoğurtlu Çorbası", 50))
        contentList.add(ContentModel(105, R.drawable.ezogelin_corbasi, "Ezogelin Çorbası", 60))

        contentList.add(ContentModel(201, R.drawable.adana_kebap, "Adana Kebap", 120))
        contentList.add(ContentModel(202, R.drawable.tantuni, "Tatntuni", 80))
        contentList.add(ContentModel(203, R.drawable.kayseri_manti, "Kayseri Mantı", 90))
        contentList.add(ContentModel(204, R.drawable.sivas_kofte, "Sivas Köfte", 120))
        contentList.add(ContentModel(205, R.drawable.nevsehir_tava, "Nevşehir Tava", 150))

        contentList.add(ContentModel(301, R.drawable.kola, "Kola", 50))
        contentList.add(ContentModel(302, R.drawable.salgam, "Şalgam", 35))
        contentList.add(ContentModel(303, R.drawable.ayran, "Ayran", 20))
        contentList.add(ContentModel(304, R.drawable.yayik_ayran, "Yayık Ayran", 25))
        contentList.add(ContentModel(305, R.drawable.soguk_cay, "Soğuk Çay", 40))

        contentList.add(ContentModel(401, R.drawable.haydari, "Haydari", 20))
        contentList.add(ContentModel(402, R.drawable.patlican_salatasi, "Patlıcan Salatası", 20))
        contentList.add(ContentModel(403, R.drawable.humus, "Humus", 20))
        contentList.add(ContentModel(404, R.drawable.muhammara, "Muhammara", 20))
        contentList.add(ContentModel(405, R.drawable.zeytin_yagli_sarma, "Zeytin Yağlı Sarma", 20))

        contentList.add(ContentModel(501, R.drawable.baklava, "Baklava", 50))
        contentList.add(ContentModel(502, R.drawable.kazandibi, "Kazandibi", 60))
        contentList.add(ContentModel(503, R.drawable.tavuk_gogusu, "Tavuk Göğüsü", 60))
        contentList.add(ContentModel(504, R.drawable.ekmek_kadayifi, "Ekmek Kadayıfı", 45))
        contentList.add(ContentModel(505, R.drawable.kunefe, "Künefe", 65))
    }

    fun getWithMenuId(id: Int): List<ContentModel> {
        when (id) {
            1 -> {
                return contentList.filter { it.id.toString().startsWith("1") }
            }

            2 -> {
                return contentList.filter { it.id.toString().startsWith("2") }
            }

            3 -> {
                return contentList.filter { it.id.toString().startsWith("3") }
            }

            4 -> {
                return contentList.filter { it.id.toString().startsWith("4") }
            }

            5 -> {
                return contentList.filter { it.id.toString().startsWith("5") }
            }

            else -> return emptyList()
        }
    }


}