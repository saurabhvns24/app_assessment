package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.trakntell.bluetooth2.DataBinderMapperImpl());
  }
}
