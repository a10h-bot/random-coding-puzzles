package com.fhlbny.fa.service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import com.fhlbny.fa.domain.AdvancePaymentShed;
import com.fhlbny.fa.repository.AdvancePaymentShedRepository;
import com.fhlbny.fa.repository.FaAdvOptRepository;
import com.fhlbny.fa.repository.FaBondOptSchedRepository;

public class CreatePasAmortThread extends Thread {
	List<Object> createAmortFiles = null;
	private String filePath;
	private  final AdvancePaymentShedRepository advancePaymentShedRepository;
	public CreatePasAmortThread(List<Object> result,String filePath,
			AdvancePaymentShedRepository advancePaymentShedRepository) {
		this.createAmortFiles = result;
		this.filePath = filePath;
		this.advancePaymentShedRepository = advancePaymentShedRepository;
	}
	public void run(){
		try{
			createAmortFiles(createAmortFiles,filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Creates Amort Files  for AdvanceAmortize in  CreatePasFiles
	 */
	public void createAmortFiles(List<Object> advanceAmortize,String filePath)  throws FileNotFoundException,IOException{
		if(advanceAmortize!=null && !advanceAmortize.isEmpty()){
			
			for(int i=0;i<advanceAmortize.size();i++){
				Object[] row=(Object[]) advanceAmortize.get(i);
				String advnoteno = (String) row[1];
				String[] str = advnoteno.split("=");
				String adv = str[1];
				List<AdvancePaymentShed> paymentShedList = advancePaymentShedRepository.getPaymentShedList(adv);
					//Files.deleteIfExists(Paths.get(FilenameUtils.getName(filePath + adv+".amort")));
					Files.deleteIfExists(Paths.get(filePath + adv+".amort"));
				FileOutputStream os = new FileOutputStream(filePath + adv+".amort",true);
				Double totalSum = getSum(paymentShedList);
				Double cumulativeAmount = 0.0;
				for(AdvancePaymentShed paymentList: paymentShedList){
					if(paymentList.getAdvPrintShedAmount() != null){
						Date payDate =paymentList.getAdvPaymentShedDate();
						os.write((new SimpleDateFormat("MM/dd/yy").format(payDate)+ '\t').getBytes());
						cumulativeAmount = cumulativeAmount + paymentList.getAdvPrintShedAmount();
						String secondCol = String.format("%.8f",  ((totalSum - cumulativeAmount)/ 1000000)); 
						
						if(secondCol.equals("0.00000000")){
							secondCol = "0";
							os.write((secondCol + '\t').getBytes());
						}
						else{
							os.write((secondCol + '\t').getBytes());
						}
						
						
						Double first = paymentList.getAdvPrintShedAmount()/totalSum;
						String str1 = first + "";
						String thirdCol;
						
						if(str1.length() > 12){
							String str2 = str1+"000";
						String str3 = str2.substring(11, 14);
						Integer value = Integer.parseInt(str3);
						
							Double second = Double.parseDouble(str1);
							if(value >= 499){
							second = second + 0.0000000006;
							}
							String splits = second+"";
							String splts2 = splits.substring(0, 11);
							
								 thirdCol = String.format("%.9f",  Double.parseDouble(splts2));
							 
						 }
						 else{
								 thirdCol = String.format("%.9f",  paymentList.getAdvPrintShedAmount()/totalSum);
						 }
						
						
						os.write((thirdCol + '\t').getBytes());
						String forthCol = String.format("%.8f",(paymentList.getAdvPrintShedAmount())/(totalSum - cumulativeAmount + paymentList.getAdvPrintShedAmount()));
						os.write((forthCol + '\t').getBytes());
						String fifthCol = String.format("%.8f", paymentList.getAdvPrintShedAmount()/1000000);
						os.write(fifthCol.getBytes());
//						os.write(System.getProperty("line.separator").getBytes());
						if(!secondCol.equals("0")){
							os.write("\r\n".getBytes());
						}
					}
				}
				os.write("\r\n".getBytes());
				//os.write(System.getProperty("line.separator").getBytes());
				os.close();
			}
		}
	}
	//getting total sum of amount
	private Double getSum(List<AdvancePaymentShed> paymentShedList) {
		Double printSum = 0.00;
		for(AdvancePaymentShed paymentList: paymentShedList){
			if(paymentList.getAdvPrintShedAmount()!= null){
				printSum = printSum + paymentList.getAdvPrintShedAmount();
			}
		}
		return printSum;
	}
}
