package memo.com.pack;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class ArrayInOb {
	  private static final FileFilter IMAGES_FILTER = new FileFilter()
	  {
	    public boolean accept(File paramFile)
	    {
	      if ((paramFile.isDirectory()) || (paramFile.getName().matches("^.*?\\.(jpg|png|bmp|gif|pnt)$")));
	      for (int i = 1; ; i = 0)
	        return i;
	    }
	  };
	  private int nElems = 0;
	  private library[] nfcp = null;

	  public static void fill(File paramFile)
	  {
	    if (library.files == null)
	    {
	      library.files = new ArrayList();
	      if (library.files != null)
	        break label34;
	    }
	    while (true)
	    {
	      return;
	      library.files.clear();
	      break;
	      label34: if (!paramFile.isDirectory())
	        continue;
	      for (File localFile : paramFile.listFiles(IMAGES_FILTER))
	        library.files.add(localFile);
	    }
	  }

	  public void display()
	  {
	    for (int i = 0; i < this.nElems; i++)
	      this.nfcp[i].displaylibary();
	    System.out.println("");
	  }

	  public String getName(int paramInt)
	  {
	    String str;
	    if (this.nfcp == null)
	      str = "";
	    while (true)
	    {
	      return str;
	      if (paramInt >= this.nElems)
	      {
	        str = "";
	        continue;
	      }
	      str = this.nfcp[paramInt].getName();
	    }
	  }

	  public String getPath(int paramInt)
	  {
	    String str;
	    if (this.nfcp == null)
	      str = "";
	    while (true)
	    {
	      return str;
	      if (paramInt >= this.nElems)
	      {
	        str = "";
	        continue;
	      }
	      str = this.nfcp[paramInt].getPath();
	    }
	  }

	  public void insert(int paramInt)
	  {
	    if (this.nfcp == null);
	    while (true)
	    {
	      return;
	      this.nfcp[this.nElems] = new library(paramInt);
	      if (this.nfcp[this.nElems] == null)
	        continue;
	      this.nElems = (1 + this.nElems);
	    }
	  }

	  public void insertionSort()
	  {
	    if (this.nfcp == null);
	    while (true)
	    {
	      return;
	      for (int i = 1; i < this.nElems; i++)
	      {
	        library locallibrary = this.nfcp[i];
	        for (int j = i; (j > 0) && (this.nfcp[(j - 1)].getName().compareTo(locallibrary.getName()) > 0); j--)
	          this.nfcp[j] = this.nfcp[(j - 1)];
	        this.nfcp[j] = locallibrary;
	      }
	    }
	  }

	  public int length()
	  {
	    return this.nElems;
	  }

	  public void make(String paramString)
	  {
	    this.nElems = 0;
	    for (int i = 0; i < library.files.size(); i++)
	      insert(i);
	    insertionSort();
	  }
	}