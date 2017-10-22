package com.example.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;
import com.example.service.PageService;

@Controller
public class PageController {


	@Autowired
	private PageService sidukDAO;
	
	
	 //VIEW PENDUDUK
    @RequestMapping(value="/penduduk/view",  method = RequestMethod.GET )
    public String viewPenduduk (Model modelpenduduk,
            @RequestParam(value = "nik", required= true) String nik)  {
       PendudukModel penduduk = sidukDAO.selectPenduduk(nik);
       	if (penduduk != null) {
            modelpenduduk.addAttribute ("penduduk", penduduk);
      
            
           	//print GolDar
            penduduk.setGolongan_darah(penduduk.getGolongan_darah().substring(0,1));
           	
            //print WNI
           	if(penduduk.getIs_wni().equals("1")) {
           		penduduk.setIs_wni("WNI");
           	} else {
           		penduduk.setIs_wni("Bukan WNI");
           	}
           		
           	//print status kematian
           	if(penduduk.getIs_wafat().equals("0")) {
           		penduduk.setIs_wafat("Hidup");
           	} else {
           		penduduk.setIs_wafat("Meninggal");
           	}
           	
           	//print tanggal lahir year/month/date(database)
           	if(penduduk.getTanggal_lahir().substring(5,7).equals("01")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Januari " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("02")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Februari " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("03")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Maret " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("04")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " April " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("05")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Mei " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("06")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Juni " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("07")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Juli " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("08")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Agustus " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("09")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " September " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("10")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Oktober " + penduduk.getTanggal_lahir().substring(0,4));
           	} else if(penduduk.getTanggal_lahir().substring(5,7).equals("11")) {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " November " + penduduk.getTanggal_lahir().substring(0,4));
           	} else {
           		penduduk.setTanggal_lahir(penduduk.getTanggal_lahir().substring(8,10) + " Desember " + penduduk.getTanggal_lahir().substring(0,4));
           	}
           	 
           		
           	return "viewPenduduk";
            //return "test";
        } else {
            modelpenduduk.addAttribute ("nik", nik);
            return "not-found";
        }
    }
    

	//VIEW KELUARGA
    @RequestMapping("/keluarga/view")
    public String viewKeluarga (Model modelkeluarga,
            @RequestParam(value = "nkk", required= true) String nkk) 
    {
    	   	
     
    	KeluargaModel keluarga = sidukDAO.selectKeluargaKK(nkk);
       	if (keluarga != null) {
       		List<PendudukModel> penduduks = (List<PendudukModel>) sidukDAO.selectPenduduks(nkk);
       	
            
       		modelkeluarga.addAttribute(penduduks);
            modelkeluarga.addAttribute ("keluarga", keluarga);
            
            
            for(int i=0; i<penduduks.size(); i++) {
    			
    			//PRINT WNI
    			if(keluarga.getPenduduks().get(i).getIs_wni().equals("1")) {
    				keluarga.getPenduduks().get(i).setIs_wni("WNI");
    			    			
    			} else {
    				keluarga.getPenduduks().get(i).setIs_wni("WNA");
    			}
            
    			//PRINT nomor_urut 
//    			keluarga.getPenduduks().get(i).setNo_urut(i+1);
    		
    			//PRINT JENIS KELAMIN
    			if(keluarga.getPenduduks().get(i).getJenis_kelamin().equals("1")) {
    				keluarga.getPenduduks().get(i).setJenis_kelamin("Perempuan");
    			}else {
    				keluarga.getPenduduks().get(i).setJenis_kelamin("Laki-laki");
    			}
    		  			
            }
    	
    		return "viewKeluarga";
           // return "test";
       
     } else {
            modelkeluarga.addAttribute ("nkk", nkk);
            return "not-found";
        }
    
    }
    
   
    //TAMBAH PENDUDUK    
    @RequestMapping(value="/penduduk/tambah",  method = RequestMethod.GET)
    public String tambahPenduduk (Model modeltambahpenduduk, PendudukModel penduduk) {
         
          
                   
           return "tambahPenduduk01";
           
    }
    
      
    @RequestMapping(value= "/penduduk/tambah", method = RequestMethod.POST)
    public String tambahPendudukSubmit (Model modelTambahPenduduk,PendudukModel penduduk, BindingResult result)
    {
    	if(result.hasErrors()) {
    		return "tambahPenduduk01";
    	} else {
    		//--kode kecamatan--
    		KeluargaModel keluarga = sidukDAO.selectKeluarga(penduduk.getId_keluarga());
    		String nikKodeKecamatan = keluarga.getKelurahan().getKecamatan().getKode_kecamatan().substring(0, 6);
    		
    		
    	
    		//--tanggal-lahir--//year/month/date ->database
    		String tanggal = penduduk.getTanggal_lahir().substring(8,10);
    		String bulan = penduduk.getTanggal_lahir().substring(5,7);
    		String tahun = penduduk.getTanggal_lahir().substring(2,4);
    		String nikTanggalLahir = tanggal + bulan + tahun;
    		
    		if(penduduk.getJenis_kelamin().equals("1")) {
    			int tanggalF = Integer.parseInt(tanggal) + 40;
    			nikTanggalLahir = tanggalF + bulan + tahun;
    			System.out.println(nikTanggalLahir);
    		}
    		
    		//gabungin dulu
    		String nikTemp= nikKodeKecamatan + nikTanggalLahir;
    		
    		//--4 angka terakhir, urutannya--
    		int i=1;
    		String nikDone = "";
    		PendudukModel ifExist = sidukDAO.selectPenduduk(nikTemp+"000" + i);
    		
    		while (ifExist != null) {
    			i++;
    			ifExist = sidukDAO.selectPenduduk(nikTemp + "000" + i);
    		}
    		
    		nikDone = nikTemp + "000" + i;
    	
    		  		
    	
    		
    		
    		
    		penduduk.setNik(nikDone);
			sidukDAO.tambahPenduduk(penduduk);
    			modelTambahPenduduk.addAttribute("nik", nikDone);
    		}
    		return "suksesTambahPenduduk";
    	
    }
	
    //TAMBAH KELUARGA
    @RequestMapping(value="/keluarga/tambah", method = RequestMethod.GET)
    public String tambahKeluarga (Model modeltambahkeluarga, KeluargaModel keluarga) {
     	
    	return "tambahKeluarga";
    }
    
    
    @RequestMapping(value="/keluarga/tambah", method = RequestMethod.POST)
    public String tambahKeluargaSubmit (Model modeltambahkeluarga, KeluargaModel keluarga, BindingResult result,
    		@RequestParam(value="alamat") String alamat,
    		@RequestParam(value="RT") int RT,
    		@RequestParam(value="RW") int RW,
    		@RequestParam(value="nama_kelurahan") String nama_kelurahan,
    		@RequestParam(value="nama_kecamatan") String nama_kecamatan,
    		@RequestParam(value="nama_kota") String nama_kota)
    		{
    	
    		//SELECT ID KELURAHAN :"""
    		KelurahanModel kel = sidukDAO.selectIDKelurahan(nama_kelurahan);
    		String id_kelurahan = kel.getId() +"";
    	
	    	//GENERATE NKK
	    	
	    	//Ambil Kode Kecamatan
	    	//String nkkKodeKecamatan = keluarga.getKelurahan().getKecamatan().getKode_kecamatan().substring(0,6);
	    	KecamatanModel kec = sidukDAO.selectKodeKecamatan(nama_kecamatan);
	    	String nkkKodeKecamatan = kec.getKode_kecamatan().substring(0,6);
    		
	    	
	    	//Ambil Tanggal Hari Ini
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	    	LocalDate localDate = LocalDate.now();
	    	System.out.println(dtf.format(localDate)); //2016/11/16
	    	String []dateToday = dtf.format(localDate).split("/");
	    	String tanggal = dateToday[2]; 
	    	String bulan = dateToday[1];
	    	String tahun = dateToday[0].substring(2, 4); 
	    	
	    	String nkkTanggalRegis = tanggal + bulan + tahun;
	    	
	    	//gabungin dulu aja lagi
	    	String nkkTemp = nkkKodeKecamatan + nkkTanggalRegis;
	    	
	    	
	    	//Ambil Urutan , --4 angka terakhir, urutannya--
			int i=1;
			String nkkDone = "";
			KeluargaModel ifExist = sidukDAO.selectKeluarga(nkkTemp + "000" + i);
			
			while (ifExist != null) {
				i++;
				ifExist = sidukDAO.selectKeluarga(nkkTemp + "000" + i);
			}
			
			nkkDone = nkkTemp + "000" + i;
	    	
	    	keluarga.setNomor_kk(nkkDone);
	    	keluarga.setAlamat(alamat);
	    	keluarga.setId_kelurahan(id_kelurahan);
	    	keluarga.setRT(RT);
	    	keluarga.setRW(RW);
	    	sidukDAO.tambahKeluarga(keluarga);
	    	modeltambahkeluarga.addAttribute("nkk", nkkDone);
	    	
	    	return "SuksesTambahKeluarga";
    	
    	//}
    }
    
    //UBAH PENDUDUK
    @RequestMapping(value="/penduduk/ubah/{nik}", method = RequestMethod.GET) 
    public String updatePenduduk(Model modelubahpenduduk, 
    		@PathVariable(value="nik") String nik) {
    		PendudukModel penduduk = sidukDAO.selectPenduduk(nik);
    		if(penduduk == null) {
    			return "not-found";
    		} else {
    			modelubahpenduduk.addAttribute("pendudukModel", penduduk); //buat nampilin th:field data yang udah ada
    			
    	
    			return "updatePenduduk";
    			
    		}
    		
    		
    }
  
 
    
    @RequestMapping(value="/penduduk/ubah/{nik}", method = RequestMethod.POST) 
    public String updatePendudukSubmit(Model modelubahpenduduk, PendudukModel penduduk, BindingResult result,
    		@PathVariable(value="nik") String nik) {
    		
    		PendudukModel selected = sidukDAO.selectPenduduk(nik);
    		
    	
    		//6 kode kecamatan, ga akan berubah
    		KeluargaModel keluarga = sidukDAO.selectKeluarga(penduduk.getId_keluarga());
    		String nikKodeKecamatan = keluarga.getKelurahan().getKecamatan().getKode_kecamatan().substring(0,6);
    		
    		//6 kode tanggal lahir, pasti berubah
    		String tanggal = penduduk.getTanggal_lahir().substring(8,10);
    		String bulan = penduduk.getTanggal_lahir().substring(5,7);
    		String tahun = penduduk.getTanggal_lahir().substring(2,4);
    		String nikTanggalLahir = tanggal + bulan + tahun;
    		
    		if(penduduk.getJenis_kelamin().equals("1")) {
    			int tanggalF = Integer.parseInt(tanggal) + 40;
    			nikTanggalLahir = tanggalF + bulan + tahun;
    			System.out.println(nikTanggalLahir);
    		}
    		

    		//gabungin dulu
    		String nikTemp= nikKodeKecamatan + nikTanggalLahir;
    		
    		

    		//--4 angka terakhir, urutannya--
    		int i=1;
    		String nikDone = "";
    		PendudukModel ifExist = sidukDAO.selectPenduduk(nikTemp+"000" + i);
    		
    		while (ifExist != null) {
    			i++;
    			ifExist = sidukDAO.selectPenduduk(nikTemp + "000" + i);
    		}
    		
    		nikDone = nikTemp + "000" + i;
    	    	    	
    		penduduk.setId(selected.getId());
    		penduduk.setNik(nikDone);
    		System.out.println(penduduk.getNama());		
	    	sidukDAO.updatePenduduk(penduduk);
	    	modelubahpenduduk.addAttribute("nik", penduduk.getNik());
	    		
    		

    		return "SuksesUpdatePenduduk";
    }
    
    //UBAH KELUARGA
    @RequestMapping(value="/keluarga/ubah/{nkk}", method= RequestMethod.GET)
    public String updateKeluarga(Model modelubahkeluarga,  
    		@PathVariable(value="nkk") String nkk) {
    	
    	KeluargaModel keluarga = sidukDAO.selectKeluargaKK(nkk);
		if(keluarga == null) {
			return "not-found";
		} else {
			modelubahkeluarga.addAttribute("keluargaModel", keluarga); // buat nampilin th:field data yang udah ada
		
			return "updateKeluarga";
			
		}
		
    	
				
	}

		
	  	
    
    
    @RequestMapping(value="/keluarga/ubah/{nkk}", method= RequestMethod.POST)
    public String updateKeluarga(Model modelubahkeluarga, KeluargaModel keluarga, 
    		@PathVariable(value="nkk") String nkk, 
    		@RequestParam(value="alamat") String alamat,
    		@RequestParam(value="RT") int RT,
    		@RequestParam(value="RW") int RW) {
    		//@RequestParam(value="kelurahan") String kelurahan){
    	
    	
    	
    	KeluargaModel selected = sidukDAO.selectKeluargaKK(nkk);
    
    	String nama_kelurahan_baru = keluarga.getKelurahan().getNama_kelurahan();
    	KelurahanModel kelurahan_baru = sidukDAO.selectIDKelurahan(nama_kelurahan_baru);
    	
    	//GENERATE NKK 6 digit pertama
    	String nama_kecamatan_baru = keluarga.getKelurahan().getKecamatan().getNama_kecamatan();
    	KecamatanModel kecamatan_baru = sidukDAO.selectKodeKecamatan(nama_kecamatan_baru);
    	String nkkKodeKecamatan = kecamatan_baru.getKode_kecamatan().substring(0,6);
    	
    	System.out.println(nkkKodeKecamatan);
    	//Ambil Tanggal Hari Ini
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	LocalDate localDate = LocalDate.now();
    	System.out.println(dtf.format(localDate)); //2016/11/16
    	String []dateToday = dtf.format(localDate).split("/");
    	String tanggal = dateToday[2]; 
    	String bulan = dateToday[1];
    	String tahun = dateToday[0].substring(2, 4); 
    	
    	String nkkTanggalRegis = tanggal + bulan + tahun;
    	//Gabungan 12 digit pertama
    	String nkkTemp = nkkKodeKecamatan + nkkTanggalRegis;
    		
    	//URUTANNYA
    	int i=1;
		String nkkDone = "";
		KeluargaModel ifExist = sidukDAO.selectKeluarga(nkkTemp + "000" + i);
		
		while (ifExist != null) {
			i++;
			ifExist = sidukDAO.selectKeluarga(nkkTemp + "000" + i);
		}
		nkkDone = nkkTemp + "000" + i;
    	
    	keluarga.setNomor_kk(nkkDone);
    	keluarga.setId(selected.getId());
      	sidukDAO.updateKeluarga(keluarga);
      	return "suksesTambahKeluarga";
    }

	
	
}
