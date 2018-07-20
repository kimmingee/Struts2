package board;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import board.pagingAction;

public class listAction extends ActionSupport 
{
      public static Reader reader; // ���� ��Ʈ���� ���� reader
 
      // SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü
      public static SqlMapClient sqlMapper;

      private List<boardVO> list = new ArrayList<boardVO>();;  
 
      private int currentPage = 1; // ���� ������
      private int totalCount; // �� �Խù��� ��
      private int blockCount = 10; // �� ��������  �Խù��� ��
      private int blockPage = 5; // �� ȭ�鿡 ������ ������ ��
      private String pagingHtml; // ����¡�� ������ html
      private pagingAction page; // ����¡ Ŭ����
 
      // ������
      public listAction() throws IOException 
      {
            // sqlMapConfig.xml ������ ���������� �����´�.
            reader = Resources.getResourceAsReader("sqlMapConfig.xml");
  
            // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����
            sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
      }

 

      // �Խ��� List �׼�
      public String execute() throws Exception 
      {
            list = sqlMapper.queryForList("selectAll"); // ��� ���� ������ list�� �ִ´�.

            totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
  
            // pagingAction ��ü ����
            page = new pagingAction(currentPage, totalCount, blockCount, blockPage); 
            pagingHtml = page.getPagingHtml().toString(); // ������ html ����

 

            // ���� ���������� ������ ������ ���� ��ȣ ����
            int lastCount = totalCount;


            /**
             * ���� �������� ������ ���� ��ȣ��
             * ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����
             */
            if(page.getEndCount() < totalCount)
                  lastCount = page.getEndCount() + 1;

 

            // ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
            list = list.subList(page.getStartCount(), lastCount);

 

            return SUCCESS;
      }
 
      public List<boardVO> getList() { return list; }
      public void setList(List<boardVO> list) { this.list = list; }

 

      public int getCurrentPage() { return currentPage; }
      public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }

 

      public int getTotalCount() { return totalCount; }
      public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

 

      public int getBlockCount() { return blockCount; }
      public void setBlockCount(int blockCount) { this.blockCount = blockCount; }

 

      public int getBlockPage() { return blockPage; }
      public void setBlockPage(int blockPage) { this.blockPage = blockPage; }

 

      public String getPagingHtml() { return pagingHtml; }
      public void setPagingHtml(String pagingHtml) { this.pagingHtml = pagingHtml; }

 

      public pagingAction getPage() { return page; }
      public void setPage(pagingAction page) { this.page = page; }
}
