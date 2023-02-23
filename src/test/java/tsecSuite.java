import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({permissionsGrantFile.class,permissionAcquiresFiles.class,folderFilePut.class,fileGet.class})
public class tsecSuite {

}