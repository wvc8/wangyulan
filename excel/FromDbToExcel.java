package excel;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class FromDbToExcel {
    public static void main(String[] args) {
        try {
            WritableWorkbook wwb = null;
             
               // ������д���Excel������
               String fileName = "D://������Ϣͳ��.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //��fileNameΪ�ļ���������һ��Workbook
               wwb = Workbook.createWorkbook(file);

               // ����������
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //��ѯ���ݿ������е�����
               List<Stu> list= StuService.getAllByDb();
               //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
               Label labelId= new Label(0, 0, "id");
               Label labelName= new Label(1, 0, "name");
               Label labelnum= new Label(2, 0, "num");
               Label labelphone= new Label(3, 0, "phone");
               Label labelacde= new Label(4, 0, "acde");
               Label labeltouch= new Label(5, 0, "touch");
               Label labelhealth= new Label(6, 0, "health");
               Label labellocate= new Label(7, 0, "locate");
               Label labelother= new Label(8, 0, "other");
               
               
               ws.addCell(labelId);
               ws.addCell(labelName);
               ws.addCell(labelnum);
               ws.addCell(labelphone);
               ws.addCell(labelacde);
               ws.addCell(labeltouch);
               ws.addCell(labelhealth);
               ws.addCell(labellocate);
               ws.addCell(labelother);
               
               for (int i = 0; i < list.size(); i++) {
                   
            	   Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
            	   Label labelName_i= new Label(1, i+1, list.get(i).getName());
                   Label labelnum_i= new Label(2, i+1, list.get(i).getnum());
                   Label labelphone_i= new Label(3, i+1, list.get(i).getphone()+"");
                   Label labelacde_i= new Label(4, i+1, list.get(i).getacde());
                   Label labeltouch_i= new Label(5, i+1, list.get(i).gettouch());
                   Label labelhealth_i= new Label(6, i+1, list.get(i).gethealth());
                   Label labellocate_i= new Label(7, i+1, list.get(i).getlocate());
                   Label labelother_i= new Label(8, i+1, list.get(i).getother());
                   
                   ws.addCell(labelId_i);
                   ws.addCell(labelName_i);
                   ws.addCell(labelnum_i);
                   ws.addCell(labelphone_i);
                   ws.addCell(labelacde_i);
                   ws.addCell(labeltouch_i);
                   ws.addCell(labelhealth_i);
                   ws.addCell(labellocate_i);
                   ws.addCell(labelother_i);
               }
             
              //д���ĵ�
               wwb.write();
              // �ر�Excel����������
               System.out.println("���ݵ����ɹ�!");
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}