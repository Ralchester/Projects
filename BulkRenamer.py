﻿import os
from tkinter import *
from tkinter import filedialog, messagebox

root = Tk()
root.title("Bulk Renamer")


def bulk_rename(text, path):
    file_num = 1

    if text:
        if path[0]:
            for file in os.listdir(path[0]):
                f = os.path.splitext(file)
                file_ext = f[1]

                new_file_name = f"{text} {file_num}{file_ext}"

                org_file = path[0] + "/" + file
                new_file = path[0] + "/" + new_file_name

                os.rename(org_file, new_file)
                file_num += 1
        else:
            messagebox.showerror("No Path", "No Directory/folder selected")
    else:
        messagebox.showerror("No Name Given", "Please fill out the 'New Name' field")


dir_path = [""]
def get_dir(dir_path, lbl_dir):
    dir_path[0] = filedialog.askdirectory()
    lbl_dir.destroy()
    lbl_dir = Label(root, text=f"Selected Dir: {dir_path}")
    lbl_dir.grid(row=2, column=0, pady=10, padx=(5,0), columnspan=3)


Label(root, text="New Name:").grid(row=0, column=0)
ent_name = Entry(root)
lbl_dir = Label(root, text="Selected Dir:None")
btn_select_dir = Button(root, text="Select Directory", command=lambda:get_dir(dir_path, lbl_dir))
btn_rename = Button(root, text="Bulk Rename Files",  command=lambda:bulk_rename(ent_name.get(), dir_path))


ent_name.grid(row=0, column=1, pady=(10, 0))
btn_select_dir.grid(row=1, column=1, pady=(20, 0))
lbl_dir.grid(row=2, column=0, pady=10, padx=(5, 0))
btn_rename.grid(row=3, column=1)


root.mainloop()

