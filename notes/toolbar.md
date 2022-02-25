##toolbar上面的菜单点击无反应

        https://androidforums.com/threads/oncreateoptionsmenu-is-never-called.1311889/
        https://microeducate.tech/oncreateoptionsmenu-not-called-in-fragment/

    虽然说这些是在activity中使用的，但在fragment中也适用，但不推荐
    没有调用fragment中的 onCreateOptionalMenu()
    fragment: 
        onCreateView 中 setHasOptionsMenu(true)
        onCreateActivity 中 (AppCompatActivity)getActivity.setSupportBar()...  设置toolbar

    注意:
    xml布局中设置了menu，代码中就不用再inflate
    
    
    fragment中
        https://www.semicolonworld.com/question/80539/oncreateoptionsmenu-is-never-called-toolbar-inflate

        As per the Fragment-owned app bar guide which explains how to use a Fragment-owned Toolbar, you do not use any of the setHasOptionsMenu(), onCreateOptionsMenu(), or onOptionsItemSelected() APIs - those are only used for activity owned app bars.
        Instead, you would follow the guide for handling menu click events by using the Toolbar APIs:

        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        toolbar =  getView().findViewById(R.id.toolbar3);
        toolbar.inflateMenu(R.menu.menufragmentmain);

         toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
               @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(getActivity(), "onMenuItemClick called" , Toast.LENGTH_LONG).show();
                    //some switch cases.....
                 return true;
             }
          });
        }


        !!!如果是 MaterialToolbar 一定要用MaterialToolbar类里的点击方法，否则点击无响应



##toolbar上面的SearchView
    可以不用单独设置一个SearchView
    在menu的布局文件里，对搜索item添加属性 
            app:actionViewClass="androidx.appcompat.widget.SearchView"
    在代码中对toolbar的一些列初始化设置(SearchView类所在的包要一致)
        ```java

        //toolbar
        toolbar.inflateMenu(R.menu.menu_top_bar);
        toolbar.setOnMenuItemClickListener(new MaterialToolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_top_bar_search:
                        Toast.makeText(getContext(), "searching...", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_top_bar_setting:
                        Toast.makeText(getContext(), "setting...", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        MenuItem menuItem = toolbar.getMenu().findItem(R.id.menu_top_bar_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("MTAG", "onQueryTextSubmit: ");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("MTAG", "onQueryTextChange: ");

                return false;
            }
        });        

        ```

            