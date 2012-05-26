package memo.com.pack;


import java.io.File;
import java.util.List;

class library
{
  static List<File> files = null;
  private int nofcop;

  public library(int paramInt)
  {
    this.nofcop = paramInt;
  }

  public void displaylibary()
  {
    if (files == null);
    while (true)
    {
      return;
      ((File)files.get(this.nofcop)).getName();
      ((File)files.get(this.nofcop)).getPath();
      ((File)files.get(this.nofcop)).getAbsolutePath();
      ((File)files.get(this.nofcop)).toString();
    }
  }

  public String getName()
  {
    String str;
    if (files == null)
      str = "";
    while (true)
    {
      return str;
      if (files.size() - 1 < this.nofcop)
      {
        str = "";
        continue;
      }
      str = ((File)files.get(this.nofcop)).getName();
    }
  }

  public String getPath()
  {
    String str;
    if (files == null)
      str = "";
    while (true)
    {
      return str;
      if (files.size() - 1 < this.nofcop)
      {
        str = "";
        continue;
      }
      str = ((File)files.get(this.nofcop)).getPath();
    }
  }
}