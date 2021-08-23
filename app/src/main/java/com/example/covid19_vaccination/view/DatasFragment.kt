package com.example.covid19_vaccination.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.covid19_vaccination.R
import com.example.covid19_vaccination.databinding.FragmentDatasBinding
import org.json.JSONObject


class DatasFragment : Fragment(R.layout.fragment_datas) {
    private lateinit var binding:FragmentDatasBinding
    val url="https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/latest/owid-covid-latest.json"
    val args:DatasFragmentArgs by navArgs()
    var temp_name=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentDatasBinding.bind(view)
        temp_name=args.ulkeAdi
       val kelime= args.ulkeAdi.converData()
        Veriler(kelime)
        binding.imageViewDatas.setImageResource(requireActivity().resources.getIdentifier(args.ulkeResim,"drawable",requireActivity().packageName))
    }

    @SuppressLint("SetTextI18n")
    private fun Veriler(kelime: String) {
        val istek=StringRequest(Request.Method.GET,url, { response ->
            try {
                    val jsonObject=JSONObject(response)
                    val datas=jsonObject.getJSONObject(kelime)
                    val continent=datas.getString("continent")
                    val last_updated_date=datas.getString("last_updated_date")
                    val total_cases=datas.getString("total_cases")
                    val new_cases=datas.getString("new_cases")
                    val new_cases_smoothed=datas.getString("new_cases_smoothed")
                    val total_deaths=datas.getString("total_deaths")
                    val new_deaths=datas.getString("new_deaths")
                    val new_deaths_smoothed=datas.getString("new_deaths_smoothed")
                    val reproduction_rate=datas.getString("reproduction_rate")
                    val icu_patients=datas.getString("icu_patients")
                    val hosp_patients=datas.getString("hosp_patients")
                    val weekly_icu_admissions=datas.getString("weekly_icu_admissions")
                    val weekly_hosp_admissions=datas.getString("weekly_hosp_admissions")
                    val new_tests=datas.getString("new_tests")
                    val total_tests=datas.getString("total_tests")
                    val new_tests_smoothed=datas.getString("new_tests_smoothed")
                    val positive_rate=datas.getString("positive_rate")
                    val total_vaccinations=datas.getString("total_vaccinations")
                    val people_vaccinated=datas.getString("people_vaccinated")
                    val people_fully_vaccinated=datas.getString("people_fully_vaccinated")
                    val total_boosters=datas.getString("total_boosters")
                    val new_vaccinations=datas.getString("new_vaccinations")
                    val new_vaccinations_smoothed=datas.getString("new_vaccinations_smoothed")
                    val stringency_index=datas.getString("stringency_index")
                    val population=datas.getString("population")
                    val population_density=datas.getString("population_density")
                    val median_age=datas.getString("median_age")
                    val aged_65_older=datas.getString("aged_65_older")
                    val aged_70_older=datas.getString("aged_70_older")
                    val cardiovasc_death_rate=datas.getString("cardiovasc_death_rate")
                    val diabetes_prevalence=datas.getString("diabetes_prevalence")
                    val female_smokers=datas.getString("female_smokers")
                    val male_smokers=datas.getString("male_smokers")
                    val handwashing_facilities=datas.getString("handwashing_facilities")
                    val hospital_beds_per_thousand=datas.getString("hospital_beds_per_thousand")
                    val life_expectancy=datas.getString("life_expectancy")
                    val human_development_index=datas.getString("human_development_index")
                    val excess_mortality=datas.getString("excess_mortality")
               binding.progressBar.visibility=View.INVISIBLE
                binding.textViewCountryNameDataFragment.text="Country ${temp_name}"
                binding.textViewCountryData.text="Continent ${continent}\nLast Updated Data ${last_updated_date}\nTotal Cases ${total_cases}\nNew Cases ${new_cases}\nNew Cases Smoothed ${new_cases_smoothed}\nTotal Deaths ${total_deaths}\nNew Deaths ${new_deaths}\nNew Deaths Smoothed ${new_deaths_smoothed}\nReproduction Rate ${reproduction_rate}\nIcu Patients ${icu_patients}\nHosp Patients ${hosp_patients}\nWeekly Icu Admissions ${weekly_icu_admissions}\nWeekly Hosp Admissions ${weekly_hosp_admissions}\nNew Tests ${new_tests}\nTotal Tests ${total_tests}\nNew Tests Smoothed ${new_tests_smoothed}\nPositive Rate ${positive_rate}\nTotal Vaccinations ${total_vaccinations}\n"+
                        "People Vaccinated ${people_vaccinated}\nPeople Fully Vaccinated ${people_fully_vaccinated}\nTotal Boosters ${total_boosters}\nNew Vaccinations ${new_vaccinations}\nNew Vaccinations Smoothed ${new_vaccinations_smoothed}\nStringency Index ${stringency_index}\nPopulation ${population}\nPopulation Density ${population_density}\nMedian Age ${median_age}\nAged 65 Older ${aged_65_older}\nAged 70 Older ${aged_70_older}\nCardiovasc Death Rate ${cardiovasc_death_rate}\n Diabetes Prevalence ${diabetes_prevalence}\nFemale Smokers ${female_smokers}\nMale Smokers ${male_smokers}\nHandwashing Facilities ${handwashing_facilities}\nHospital Beds Per Thousand ${hospital_beds_per_thousand}\n Life Expectancy ${life_expectancy}\n Human Development Index ${human_development_index}"
            }catch (e:Exception){
                Log.e("Hata",e.localizedMessage.toString())
            }
        }, {

        })
        Volley.newRequestQueue(requireContext()).add(istek)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_data,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }



}
private fun String.converData():String {
    var donen=""
    when (this){
        ("Afghanistan")->{ donen=("AFG")}
        ("Africa")->{donen=("OWID_AFR") }
        ("Albania")->{ donen=("ALB")}
        ("Algeria")->{donen=("DZA") }
        ("Andorra")->{ donen=("AND")}
        ("Angola")->{ donen=("AGO")}
        ("Antigua and Barbuda")->{  donen=("ATG") }
        ("Argentina")->{ donen=("ARG")}
        ("Aruba")->{donen=("ARM") }
        ("Armenia")->{ donen=("ABW") }
        ("Asia")->{ donen=("OWID_ASI") }
        ("Australia")->{ donen=("AUS")}
        ("Austria")->{ donen=("AUT")}
        ("Azerbaijan")->{ donen=("AZE")}
        ("Bahamas")->{ donen=("BHS")}
        ("Bahrain")->{ donen=("BHR")}
        ("Bangladesh")->{ donen=("BGD")}
        ("Barbados")->{ donen=("BRB")}
        ("Belarus")->{ donen=("BLR")}
        ("Belgium")->{ donen=("BEL")}
        ("Belize")->{ donen=("BLZ")}
        ("Benin")->{ donen=("BEN")}
        ("Bermuda")->{ donen=("BMU")}
        ("Bhutan")->{ donen=("BTN")}
        ("Bolivia")->{ donen=("BOL")}
        ("Bosnia and Herzegovina")->{donen=("BIH") }
        ("Botswana")->{ donen=("BWA")}
        ("Brazil")->{ donen=("BRA")}
        ("British Virgin Islands")->{donen=("VGB") }
        ("Brunei")->{ donen=("BRN")}
        ("Bulgaria")->{ donen=("BGR")}
        ("Burkina Faso")->{ donen=("BFA")}
        ("Burundi")->{ donen=("BDI")}
        ("Cambodia")->{ donen=("KMH")}
        ("Cameroon")->{ donen=("CMR")}
        ("Canada")->{ donen=("CAN")}
        ("Cape Verde")->{ donen=("CPV")}
        ("Cayman Islands")->{ donen=("CYM")}
        ("Central African Republic")->{ donen=("CAF")}
        ("Chad")->{ donen=("TCD")}
        ("Chile")->{ donen=("CHL")}
        ("China")->{ donen=("CHN")}
        ("Colombia")->{ donen=("COL")}
        ("Comoros")->{ donen=("COM")}
        ("Congo")->{ donen=("COG")}
        ("Costa Rica")->{ donen=("CRI")}
        ("Cote d'Ivoire")->{ donen=("CIV")}
        ("Croatia")->{ donen=("HRV")}
        ("Cuba")->{donen=("CUB") }
        ("Curacao")->{ donen=("CUW")}
        ("Cyprus")->{ donen=("CYP")}
        ("Czechia")->{ donen=("CZE")}
        ("Democratic Republic of Congo")->{donen=("COD") }
        ("Denmark")->{ donen=("DNK")}
        ("Djibouti")->{ donen=("DJI")}
        ("Dominica")->{ donen=("DMA")}
        ("Dominican Republic")->{donen=("DOM") }
        ("Ecuador")->{ donen=("ECU")}
        ("Egypt")->{ donen=("EGY")}
        ("El Salvador")->{ donen=("SLV")}
        ("Equatorial Guinea")->{ donen=("GNQ")}
        ("Eritrea")->{ donen=("ERI")}
        ("Estonia")->{ donen=("EST")}
        ("Eswatini")->{ donen=("SWZ")}
        ("Ethiopia")->{ donen=("ETH")}
        ("Europe")->{ donen=("OWID_EUR")}
        ("European Union")->{ donen=("OWID_EUN")}
        ("Faeroe Islands")->{ donen=("FRO")}
        ("Fiji")->{ donen=("FJI")}
        ("Finland")->{ donen=("FIN")}
        ("France")->{ donen=("FRA")}
        ("French Polynesia")->{ donen=("PYF")}
        ("Gabon")->{ donen=("GAB")}
        ("Gambia")->{ donen=("GMB")}
        ("Georgia")->{ donen=("GEO")}
        ("Germany")->{ donen=("DEU")}
        ("Ghana")->{ donen=("GHA")}
        ("Gibraltar")->{ donen=("GIB")}
        ("Greece")->{ donen=("GRC")}
        ("Greenland")->{ donen=("GRL")}
        ("Grenada")->{ donen=("GRD")}
        ("Guatemala")->{ donen=("GTM")}
        ("Guernsey")->{ donen=("GGY")}
        ("Guinea")->{ donen=("GIN")}
        ("Guinea-Bissau")->{ donen=("GNB")}
        ("Guyana")->{ donen=("GUY")}
        ("Haiti")->{ donen=("HTI")}
        ("Honduras")->{ donen=("HND")}
        ("Hong Kong")->{ donen=("HKG")}
        ("Hungary")->{ donen=("HUN")}
        ("Iceland")->{ donen=("ISL")}
        ("India")->{ donen=("IND")}
        ("Indonesia")->{ donen=("IDN")}
        ("International")->{ donen=("OWID_INT")}
        ("Iran")->{ donen=("IRN")}
        ("Iraq")->{ donen=("IRQ")}
        ("Ireland")->{ donen=("IRL")}
        ("Isle of Man")->{ donen=("IMN")}
        ("Israel")->{ donen=("ISR")}
        ("Italy")->{ donen=("ITA")}
        ("Jamaica")->{ donen=("JAM")}
        ("Japan")->{ donen=("JPN")}
        ("Jersey")->{ donen=("JEY")}
        ("Jordan")->{ donen=("JOR")}
        ("Kazakhstan")->{ donen=("KAZ")}
        ("Kenya")->{ donen=("KEN")}
        ("Kiribati")->{ donen=("KIR")}
        ("Kosovo")->{ donen=("OWID_KOS")}
        ("Kuwait")->{ donen=("KWT")}
        ("Kyrgyzstan")->{ donen=("KGZ")}
        ("Laos")->{ donen=("LAO")}
        ("Latvia")->{ donen=("LVA")}
        ("Lebanon")->{ donen=("LBN")}
        ("Lesotho")->{ donen=("LSO")}
        ("Liberia")->{donen=("LBR") }
        ("Libya")->{ donen=("LBY")}
        ("Liechtenstein")->{ donen=("LTE")}
        ("Lithuania")->{ donen=("LTU")}
        ("Luxembourg")->{ donen=("LUX")}
        ("Macao")->{donen=("MAC") }
        ("Madagascar")->{ donen=("MDG")}
        ("Malawi")->{ donen=("MWI")}
        ("Malaysia")->{ donen=("MYS")}
        ("Maldives")->{ donen=("MDV")}
        ("Mali")->{ donen=("MLI")}
        ("Marshall Islands")->{donen=("MHL") }
        ("Mauritania")->{ donen=("MRT")}
        ("Mauritius")->{ donen=("MUS")}
        ("Mexico")->{ donen=("MEX")}
        ("Micronesia  country)")->{donen=("FSM") }
        ("Moldova")->{ donen=("MDA")}
        ("Monaco")->{ donen=("MCO")}
        ("Mongolia")->{ donen=("MNG")}
        ("Montenegro")->{ donen=("MNE")}
        ("Morocco")->{ donen=("MAR")}
        ("Mozambique")->{ donen=("MOZ")}
        ("Myanmar")->{ donen=("MMR")}
        ("Namibia")->{ donen=("NAM")}
        ("Nepal")->{ donen=("NPL")}
        ("Netherlands")->{ donen=("NLD")}
        ("New Caledonia")->{ donen=("NCL")}
        ("New Zealand")->{ donen=("NZL")}
        ("Nicaragua")->{ donen=("NIC")}
        ("Niger")->{ donen=("NER")}
        ("Nigeria")->{ donen=("NGA")}
        ("Niue")->{ donen=("NIU")}
        ("North America")->{ donen=("OWID_NAM")}
        ("North Macedonia")->{ donen=("MKD")}
        ("Northern Cyprus")->{ donen=("OWID_CYN")}
        ("Norway")->{ donen=("NOR")}
        ("Oceania")->{ donen=("OWID_OCE")}
        ("Oman")->{ donen=("OMN")}
        ("Pakistan")->{ donen=("PAK")}
        ("Palestine")->{ donen=("PSE")}
        ("Panama")->{ donen=("PAN")}
        ("Papua New Guinea")->{donen=("PNG") }
        ("Paraguay")->{ donen=("PRY")}
        ("Peru")->{ donen=("PER")}
        ("Philippines")->{ donen=("PHL")}
        ("Poland")->{ donen=("POL")}
        ("Portugal")->{ donen=("PRT")}
        ("Qatar")->{ donen=("QAT")}
        ("Romania")->{ donen=("ROU")}
        ("Russia")->{ donen=("RUS")}
        ("Rwanda")->{ donen=("RWA")}
        ("Saint Kitts and Nevis")->{ donen=("KNA")}
        ("Saint Lucia")->{ donen=("LCA")}
        ("Saint Vincent and the Grenadines")->{ donen=("VCT")}
        ("Samoa")->{ donen=("WSM")}
        ("San Marino")->{ donen=("SMR")}
        ("Sao Tome and Principe")->{donen=("STP") }
        ("Saudi Arabia")->{donen=("SAU") }
        ("Senegal")->{ donen=("SEN")}
        ("Serbia")->{ donen=("SRB")}
        ("Seychelles")->{ donen=("SYC")}
        ("Sierra Leone")->{ donen=("SLE")}
        ("Singapore")->{ donen=("SGP")}
        ("Sint Maarten  Dutch part)")->{ donen=("SXM")}
        ("Slovakia")->{ donen=("SVK")}
        ("Slovenia")->{ donen=("SVN")}
        ("Solomon Islands")->{ donen=("SLB")}
        ("Somalia")->{ donen=("SOM")}
        ("South Africa")->{ donen=("ZAF")}
        ("South America")->{ donen=("OWID_SAM")}
        ("South Korea")->{ donen=("KOR")}
        ("South Sudan")->{ donen=("SSD")}
        ("Spain")->{ donen=("ESP")}
        ("Sri Lanka")->{ donen=("LKA")}
        ("Sudan")->{ donen=("SDN")}
        ("Suriname")->{ donen=("SUR")}
        ("Sweden")->{ donen=("SWE")}
        ("Switzerland")->{ donen=("CHE")}
        ("Syria")->{ donen=("SYR")}
        ("Taiwan")->{ donen=("TWN")}
        ("Tajikistan")->{ donen=("TJK")}
        ("Tanzania")->{ donen=("TZA")}
        ("Thailand")->{ donen=("THA")}
        ("Timor")->{ donen=("TLS")}
        ("Togo")->{ donen=("TGO")}
        ("Tokelau")->{ donen=("TKL")}
        ("Trinidad and Tobago")->{donen=("TTO") }
        ("Tunisia")->{ donen=("TUN")}
        ("Turkey")->{ donen=("TUR")}
        ("Turks and Caicos Islands")->{donen=("TCA") }
        ("Uganda")->{ donen=("UGA")}
        ("Ukraine")->{ donen=("UKR")}
        ("United Arab Emirates")->{donen=("ARE") }
        ("United Kingdom")->{ donen=("GBR")}
        ("United States")->{ donen=("USA")}
        ("Uruguay")->{ donen=("URY")}
        ("Uzbekistan")->{ donen=("UZB")}
        ("Vanuatu")->{ donen=("VUT")}
        ("Vatican")->{ donen=("VAT")}
        ("Venezuela")->{ donen=("VEN")}
        ("Vietnam")->{ donen=("VNM")}
        ("Wallis and Futuna")->{ donen=("WLF")}
        ("World")->{ donen=("OWID_WRL")}
        ("Yemen")->{ donen=("YEM")}
        ("Zambia")->{ donen=("ZMB")}
        ("Zimbabwe")->{ donen=("ZWE")}
        ("Malta")->{ donen=("MLT")}


        else->{

        }

    }
    return donen
}
