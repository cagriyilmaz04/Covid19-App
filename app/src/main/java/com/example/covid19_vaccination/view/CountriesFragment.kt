package com.example.covid19_vaccination.view

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19_vaccination.R
import com.example.covid19_vaccination.adapter.Adapter_Countries
import com.example.covid19_vaccination.databinding.FragmentCountriesBinding
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList


class CountriesFragment : Fragment(R.layout.fragment_countries) {
    private var country_names=ArrayList<String>()
   lateinit var binding:FragmentCountriesBinding
    private var country_images=ArrayList<String>()

private  var temp_array=ArrayList<String>()
    private var temp_picture=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_countries,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= FragmentCountriesBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)
       try {
           fill_array(country_names)
           temp_array.addAll(country_names)
           fill_image_array(country_images)
           temp_picture.addAll(country_images)
           val recycler=Adapter_Countries(temp_array,temp_picture,requireContext())
           binding.recyclerViewCountryFragment.layoutManager=LinearLayoutManager(requireContext())
           binding.recyclerViewCountryFragment.adapter=recycler

       }catch (e:Exception){
           Toast.makeText(requireContext(),e.localizedMessage,Toast.LENGTH_LONG).show()
       }

    }

    fun fill_array(country_code:ArrayList<String>){
        country_code.add("Afghanistan")
        country_code.add("Africa")
        country_code.add("Albania")
        country_code.add("Algeria")
        country_code.add("Andorra")
        country_code.add("Angola")
        country_code.add("Antigua and Barbuda")
        country_code.add("Argentina")
        country_code.add("Aruba")
        country_code.add("Armenia")
        country_code.add("Asia")
        country_code.add("Australia")
        country_code.add("Austria")
        country_code.add("Azerbaijan")
        country_code.add("Bahamas")
        country_code.add("Bahrain")
        country_code.add("Bangladesh")
        country_code.add("Barbados")
        country_code.add("Belarus")
        country_code.add("Belgium")
        country_code.add("Belize")
        country_code.add("Benin")
        country_code.add("Bermuda")
        country_code.add("Bhutan")
        country_code.add("Bolivia")
        country_code.add("Bosnia and Herzegovina")
        country_code.add("Botswana")
        country_code.add("Brazil")
        country_code.add("British Virgin Islands")
        country_code.add("Brunei")
        country_code.add("Bulgaria")
        country_code.add("Burkina Faso")
        country_code.add("Burundi")
        country_code.add("Cambodia")
        country_code.add("Cameroon")
        country_code.add("Canada")
        country_code.add("Cape Verde")
        country_code.add("Cayman Islands")
        country_code.add("Central African Republic")
        country_code.add("Chad")
        country_code.add("Chile")
        country_code.add("China")
        country_code.add("Colombia")
        country_code.add("Comoros")
        country_code.add("Congo")
        country_code.add("Costa Rica")
        country_code.add("Cote d'Ivoire")
        country_code.add("Croatia")
        country_code.add("Cuba")
        country_code.add("Curacao")
        country_code.add("Cyprus")
        country_code.add("Czechia")
        country_code.add("Democratic Republic of Congo")
        country_code.add("Denmark")
        country_code.add("Djibouti")
        country_code.add("Dominica")
        country_code.add("Dominican Republic")
        country_code.add("Ecuador")
        country_code.add("Egypt")
        country_code.add("El Salvador")
        country_code.add("Equatorial Guinea")
        country_code.add("Eritrea")
        country_code.add("Estonia")
        country_code.add("Eswatini")
        country_code.add("Ethiopia")
        country_code.add("Europe")
        country_code.add("European Union")
        country_code.add("Faeroe Islands")
        country_code.add("Fiji")
        country_code.add("Finland")
        country_code.add("France")
        country_code.add("French Polynesia")
        country_code.add("Gabon")
        country_code.add("Gambia")
        country_code.add("Georgia")
        country_code.add("Germany")
        country_code.add("Ghana")
        country_code.add("Gibraltar")
        country_code.add("Greece")
        country_code.add("Greenland")
        country_code.add("Grenada")
        country_code.add("Guatemala")
        country_code.add("Guernsey")
        country_code.add("Guinea")
        country_code.add("Guinea-Bissau")
        country_code.add("Guyana")
        country_code.add("Haiti")
        country_code.add("Honduras")
        country_code.add("Hong Kong")
        country_code.add("Hungary")
        country_code.add("Iceland")
        country_code.add("India")
        country_code.add("Indonesia")
        country_code.add("International")
        country_code.add("Iran")
        country_code.add("Iraq")
        country_code.add("Ireland")
        country_code.add("Isle of Man")
        country_code.add("Israel")
        country_code.add("Italy")
        country_code.add("Jamaica")
        country_code.add("Japan")
        country_code.add("Jersey")
        country_code.add("Jordan")
        country_code.add("Kazakhstan")
        country_code.add("Kenya")
        country_code.add("Kiribati")
        country_code.add("Kosovo")
        country_code.add("Kuwait")
        country_code.add("Kyrgyzstan")
        country_code.add("Laos")
        country_code.add("Latvia")
        country_code.add("Lebanon")
        country_code.add("Lesotho")
        country_code.add("Liberia")
        country_code.add("Libya")
        country_code.add("Liechtenstein")
        country_code.add("Lithuania")
        country_code.add("Luxembourg")
        country_code.add("Macao")
        country_code.add("Madagascar")
        country_code.add("Malawi")
        country_code.add("Malaysia")
        country_code.add("Maldives")
        country_code.add("Mali")
        country_code.add("Marshall Islands")
        country_code.add("Mauritania")
        country_code.add("Mauritius")
        country_code.add("Mexico")
        country_code.add("Micronesia (country)")
        country_code.add("Moldova")
        country_code.add("Monaco")
        country_code.add("Mongolia")
        country_code.add("Montenegro")
        country_code.add("Morocco")
        country_code.add("Mozambique")
        country_code.add("Myanmar")
        country_code.add("Namibia")
        country_code.add("Nepal")
        country_code.add("Netherlands")
        country_code.add("New Caledonia")
        country_code.add("New Zealand")
        country_code.add("Nicaragua")
        country_code.add("Niger")
        country_code.add("Nigeria")
        country_code.add("Niue")
        country_code.add("North America")
        country_code.add("North Macedonia")
        country_code.add("Northern Cyprus")
        country_code.add("Norway")
        country_code.add("Oceania")
        country_code.add("Oman")
        country_code.add("Pakistan")
        country_code.add("Palestine")
        country_code.add("Panama")
        country_code.add("Papua New Guinea")
        country_code.add("Paraguay")
        country_code.add("Peru")
        country_code.add("Philippines")
        country_code.add("Poland")
        country_code.add("Portugal")
        country_code.add("Qatar")
        country_code.add("Romania")
        country_code.add("Russia")
        country_code.add("Rwanda")
        country_code.add("Saint Kitts and Nevis")
        country_code.add("Saint Lucia")
        country_code.add("Saint Vincent and the Grenadines")
        country_code.add("Samoa")
        country_code.add("San Marino")
        country_code.add("Sao Tome and Principe")
        country_code.add("Saudi Arabia")
        country_code.add("Senegal")
        country_code.add("Serbia")
        country_code.add("Seychelles")
        country_code.add("Sierra Leone")
        country_code.add("Singapore")
        country_code.add("Sint Maarten (Dutch part)")
        country_code.add("Slovakia")
        country_code.add("Slovenia")
        country_code.add("Solomon Islands")
        country_code.add("Somalia")
        country_code.add("South Africa")
        country_code.add("South America")
        country_code.add("South Korea")
        country_code.add("South Sudan")
        country_code.add("Spain")
        country_code.add("Sri Lanka")
        country_code.add("Sudan")
        country_code.add("Suriname")
        country_code.add("Sweden")
        country_code.add("Switzerland")
        country_code.add("Syria")
        country_code.add("Taiwan")
        country_code.add("Tajikistan")
        country_code.add("Tanzania")
        country_code.add("Thailand")
        country_code.add("Timor")
        country_code.add("Togo")
        country_code.add("Tokelau")
        country_code.add("Trinidad and Tobago")
        country_code.add("Tunisia")
        country_code.add("Turkey")
        country_code.add("Turks and Caicos Islands")
        country_code.add("Uganda")
        country_code.add("Ukraine")
        country_code.add("United Arab Emirates")
        country_code.add("United Kingdom")
        country_code.add("United States")
        country_code.add("Uruguay")
        country_code.add("Uzbekistan")
        country_code.add("Vanuatu")
        country_code.add("Vatican")
        country_code.add("Venezuela")
        country_code.add("Vietnam")
        country_code.add("Wallis and Futuna")
        country_code.add("World")
        country_code.add("Yemen")
        country_code.add("Zambia")
        country_code.add("Zimbabwe")
        country_code.add("Malta")



    }
    fun fill_image_array(image_list:ArrayList<String>){
        for(i in 0..220){
            image_list.add("resim${i}")
        }
    }

    fun fill_array1(country_code:ArrayList<String>){
        country_code.add("AFG")
        country_code.add("OWID_AFR")
        country_code.add("ALB")
        country_code.add("DZA")
        country_code.add("AND")
        country_code.add("AGO")
        country_code.add("AIA")
        country_code.add("ATG")
        country_code.add("ARG")
        country_code.add("ARM")
        country_code.add("ABW")
        country_code.add("OWID_ASI")
        country_code.add("AUS")
        // country_code.add("AUT")
        country_code.add("AZE")
        country_code.add("BHS")
        country_code.add("BHR")
        country_code.add("BGD")
        country_code.add("BRB")
        country_code.add("BLR")
        country_code.add("BEL")
        country_code.add("BLZ")
        country_code.add("BEN")
        country_code.add("BMU")
        country_code.add("BTN")
        country_code.add("BOL")
        country_code.add("BIH")
        country_code.add("BWA")
        country_code.add("BRA")
        country_code.add("VGB")
        country_code.add("BRN")
        country_code.add("BGR")
        country_code.add("BFA")
        country_code.add("BDI")
        country_code.add("KHM")
        country_code.add("CMR")
        country_code.add("CAN")
        country_code.add("CPV")
        country_code.add("CYM")
        country_code.add("CAF")
        country_code.add("TCD")
        country_code.add("CHL")
        country_code.add("CHN")
        country_code.add("COL")
        country_code.add("COM")
        country_code.add("COG")
        country_code.add("CRI")
        country_code.add("CIV")
        country_code.add("HRV")
        country_code.add("CUB")
        country_code.add("CUW")
        country_code.add("CYP")
        country_code.add("CZE")
        country_code.add("COD")
        country_code.add("DNK")
        country_code.add("DJI")
        country_code.add("DMA")
        country_code.add("DOM")
        country_code.add("ECU")
        country_code.add("EGY")
        country_code.add("SLV")
        country_code.add("GNQ")
        country_code.add("ERI")
        country_code.add("EST")
        country_code.add("SWZ")
        country_code.add("ETH")
        country_code.add("OWID_EUR")
        country_code.add("OWID_EUN")
        country_code.add("FRO")
        country_code.add("FJI")
        country_code.add("FIN")
        country_code.add("FRA")
        country_code.add("PYF")
        country_code.add("GAB")
        country_code.add("GMB")
        country_code.add("GEO")
        country_code.add("DEU")
        country_code.add("GHA")
        country_code.add("GIB")
        country_code.add("GRC")
        country_code.add("GRL")
        country_code.add("GRD")
        country_code.add("GTM")
        country_code.add("GGY")
        country_code.add("GIN")
        country_code.add("GNB")
        country_code.add("GUY")
        country_code.add("HTI")
        country_code.add("HND")
        country_code.add("HKG")
        country_code.add("HUN")
        country_code.add("ISL")
        country_code.add("IND")
        country_code.add("IDN")
        country_code.add("OWID_INT")
        country_code.add("IRN")
        country_code.add("IRQ")
        country_code.add("IRL")
        country_code.add("IMN")
        country_code.add("ISR")
        country_code.add("ITA")
        country_code.add("JAM")
        country_code.add("JPN")
        country_code.add("JEY")
        country_code.add("JOR")
        country_code.add("KAZ")
        country_code.add("KEN")
        country_code.add("KIR")
        country_code.add("OWID_KOS")
        country_code.add("KWT")
        country_code.add("KGZ")
        country_code.add("LAO")
        country_code.add("LVA")
        country_code.add("LBN")
        country_code.add("LSO")
        country_code.add("LBR")
        country_code.add("LBY")
        country_code.add("LIE")
        country_code.add("LTU")
        country_code.add("LUX")
        country_code.add("MAC")
        country_code.add("MDG")
        country_code.add("MWI")
        country_code.add("MYS")
        country_code.add("MDV")
        country_code.add("MLI")
        country_code.add("MLT")
        country_code.add("MHL")
        country_code.add("MRT")
        country_code.add("MUS")
        country_code.add("MEX")
        country_code.add("FSM")
        country_code.add("MDA")
        country_code.add("MCO")
        country_code.add("MNG")
        country_code.add("MNE")
        country_code.add("MSR")
        country_code.add("MAR")
        country_code.add("MOZ")
        country_code.add("MMR")
        country_code.add("NAM")
        country_code.add("NPL")
        country_code.add("NLD")
        country_code.add("NCL")
        country_code.add("NZL")
        country_code.add("NIC")
        country_code.add("NER")
        country_code.add("NGA")
        country_code.add("NIU")
        country_code.add("OWID_NAM")
        country_code.add("MKD")
        country_code.add("OWID_CYN")
        country_code.add("NOR")
        country_code.add("OWID_OCE")
        country_code.add("OMN")
        country_code.add("PAK")
        country_code.add("PSE")
        country_code.add("PAN")
        country_code.add("PNG")
        country_code.add("PRY")
        country_code.add("PER")
        country_code.add("PHL")
        country_code.add("POL")
        country_code.add("PRT")
        country_code.add("QAT")
        country_code.add("ROU")
        country_code.add("RUS")
        country_code.add("RWA")
        country_code.add("KNA")
        country_code.add("LCA")
        country_code.add("VCT")
        country_code.add("WSM")
        country_code.add("SMR")
        country_code.add("STP")
        country_code.add("SAU")
        country_code.add("SEN")
        country_code.add("SRB")
        country_code.add("SYC")
        country_code.add("SLE")
        country_code.add("SGP")
        country_code.add("SXM")
        country_code.add("SVK")
        country_code.add("SVN")
        country_code.add("SLB")
        country_code.add("SOM")
        country_code.add("ZAF")
        country_code.add("OWID_SAM")
        country_code.add("KOR")
        country_code.add("SSD")
        country_code.add("ESP")
        country_code.add("LKA")
        country_code.add("SDN")
        country_code.add("SUR")
        country_code.add("SWE")
        country_code.add("CHE")
        country_code.add("SYR")
        country_code.add("TWN")
        country_code.add("TJK")
        country_code.add("TZA")
        country_code.add("THA")
        country_code.add("TLS")
        country_code.add("TGO")
        country_code.add("TKL")
        country_code.add("TTO")
        country_code.add("TUN")
        country_code.add("TUR")
        country_code.add("TCA")
        country_code.add("UCA")
        country_code.add("UKR")
        country_code.add("ARE")
        country_code.add("GBR")
        country_code.add("USA")
        country_code.add("URY")
        country_code.add("UZB")
        country_code.add("VUT")
        country_code.add("VAT")
        country_code.add("VEN")
        country_code.add("VNM")
        country_code.add("WLF")
        country_code.add("OWID_WRL")
        country_code.add("YEM")
        country_code.add("ZMB")
        country_code.add("ZWE")


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_data,menu)
        val item= menu.findItem(R.id.search)
        val searchView=(item.actionView) as SearchView
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                temp_array.clear()
                temp_picture.clear()
                val searchText=newText!!.toLowerCase(Locale.getDefault())

                if(searchText.isNotEmpty()){
                    for(i in 0 until country_names.size){
                        if(country_names.get(i).toLowerCase(Locale.getDefault()).contains(searchText)){
                            temp_array.add(country_names.get(i))
                            temp_picture.add(country_images.get(i))
                            binding.recyclerViewCountryFragment.adapter?.notifyDataSetChanged()
                        }

                    }
                    }
                else{
                    temp_array.clear()
                    temp_array.addAll(country_names)
                    temp_picture.clear()
                    temp_picture.addAll(country_images)
                    binding.recyclerViewCountryFragment.adapter?.notifyDataSetChanged()
                }
                return false
            }

        })

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}