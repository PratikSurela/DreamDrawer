<h1 style="text-align: center;"><span style="color: #333333;"><strong>Dream Drawer</strong></span></h1>
<p style="text-align: center;">&nbsp;</p>
<h1 style="text-align: center;"><img style="display: block; margin-left: auto; margin-right: auto;" title="this slowpoke moves" src="https://raw.githubusercontent.com/PratikSurela/DreamDrawer/master/output.gif" width="190" height="350" /></h1>
<p>&nbsp;</p>
<p>"Dream Drawer" is a custom navigation drawer that uses <span style="color: #800080;"><strong>RecyclerView</strong></span> with <span style="color: #800080;"><strong>header layout</strong></span> and <span style="color: #800080;"><strong>DrawerLayout</strong></span>.</p>
<p><strong>Step 1 :</strong> Add following dependencies for recyclerview</p>
<p>implementation 'com.android.support:design:27.1.1'</p>
<p><strong>Step 2 :</strong> Copy <span style="color: #800080;"><strong>"Drawer"</strong></span> package and paste into your project&nbsp;</p>
<p><span style="color: #800080;"><strong>"DrawerActivity"</strong></span> is responsible to handle whole drawer selection, icons and title of the drawer items.</p>
<p><strong>Step 3 :</strong> To change the icons and title change in below lines</p>
<pre>drawerItemList.add(new DrawerItem(R.drawable.ic_home, R.drawable.ic_home_white, getString(R.string.home)));</pre>
<p>where first icon is 1st argue for grey icon, 2nd argu for white icon and 3rd argu for for title of drawer item, so change according to your requirements.</p>
<p><strong>Step 4 :</strong> Handle item click using <span style="color: #800080;">"<strong>onDrawerListClick</strong>"</span> method and you can change fragments here.</p>
<p>That's it. Enjoy Coding!<img src="https://html-online.com/editor/tinymce4_6_5/plugins/emoticons/img/smiley-smile.gif" alt="smile" /></p>
